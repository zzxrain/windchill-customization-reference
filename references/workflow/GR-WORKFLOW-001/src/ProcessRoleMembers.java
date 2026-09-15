package com.company.windchill.reference.workflow;

import java.util.ArrayList;
import java.util.HashMap;

import wt.fc.WTObject;
import wt.project.Role;
import wt.team.Team;
import wt.team.TeamHelper;
import wt.team.TeamManaged;
import wt.util.WTException;

public final class ProcessRoleMembers {

    public static int count(WTObject object, String roleInternalName) throws WTException {
        Team team = TeamHelper.service.getTeam((TeamManaged) object);
        HashMap<?, ?> participantsByRole = TeamHelper.service.findAllParticipantsByRole(team);

        for (Object key : participantsByRole.keySet()) {
            if (!(key instanceof Role)) {
                continue;
            }

            Role role = (Role) key;
            if (roleInternalName.equals(role.toString())) {
                ArrayList<?> participants = (ArrayList<?>) participantsByRole.get(role);
                return participants == null ? 0 : participants.size();
            }
        }

        return 0;
    }

    private ProcessRoleMembers() {
    }
}
