package com.company.windchill.reference.xworks;

import java.util.Locale;

import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.TableConfig;
import com.ptc.xworks.ConfigurationException;
import com.ptc.xworks.XworksConstants;
import com.ptc.xworks.util.XWorksHelper;
import com.ptc.xworks.workflow.TableConfigBuilder;
import com.ptc.xworks.workflow.annotation.AttachmentGroupDef;
import com.ptc.xworks.workflow.template.WorkflowTemplateInfo;
import com.ptc.xworks.workflow.template.WorkflowTemplateInfoService;

import wt.session.SessionHelper;
import wt.util.WTException;
import wt.util.WTMessage;
import wt.workflow.work.WorkItem;

public class AttachmentGroupConfigBuilder implements TableConfigBuilder {

    @Override
    public TableConfig buildTableConfig(
            ComponentParams params,
            ComponentConfigFactory factory,
            TableConfig tableConfig) throws WTException {

        WorkItem workItem = (WorkItem) params.getContextObject();

        WorkflowTemplateInfoService service =
                XWorksHelper.getWorkflowTemplateInfoService();

        WorkflowTemplateInfo templateInfo =
                service.getWorkflowTemplateInfoByWorkItem(workItem);

        if (templateInfo == null) {
            throw new ConfigurationException(
                    "Cannot get WorkflowTemplateInfo by WorkItem");
        }

        String groupId = (String) params.getParameter("groupId");
        AttachmentGroupDef group = templateInfo.getAttachmentGroupDef(groupId);

        if (tableConfig == null) {
            tableConfig = factory.newTableConfig();
        }

        tableConfig.setId(
                "attachmentGroup"
                        + XworksConstants.TABLE_ID_DELIMITER
                        + group.groupId());

        Locale locale = SessionHelper.getLocale();
        tableConfig.setLabel(
                WTMessage.getLocalizedMessage(
                        group.name().resourceBundle(),
                        group.name().key(),
                        null,
                        locale));

        tableConfig.setSelectable(true);
        return tableConfig;
    }
}
