# Golden Reference Catalog

当前共 **62** 个候选 Reference。

## ID 规则

Reference ID 采用模块独立流水：

```text
GR-<MODULE>-<NNN>
```

规则：

- 每个模块从 `001` 独立递增。
- 新增 Reference 只增加所属模块的下一个序号。
- 已发布 ID 不因排序、删除或新增而重新编号；允许保留空号。
- ID 用于目录名、`reference.md` 元数据和项目显式引用，应保持稳定。

## Provenance

当前候选主要包含三类来源：

- `Legacy Project`：从历史项目代码中抽取并去客户化、规范化。
- `PTC Guide`：从 Windchill 13.1.2.0 Customization Guide 的典型模式中整理并最小化。
- `XWorks Guide`：从 XWorks 指南或经过整理的 XWorks 实践中提炼，仅适用于明确启用 XWorks 的项目。

当前条目均保持 `candidate`。

`PTC Guide` 来源通常更适合作为 Windchill 官方扩展机制的默认实现参考；`Legacy Project` 用于补充真实项目工程上下文；`XWorks Guide` 仅在项目明确 `XWorks Enabled: true` 时作为实现候选。

任何来源都不代表目标项目已经编译或 Runtime Verification 通过，精确 PTC API 仍应针对目标 Windchill Version 使用 Javadoc / API Lookup 验证。

## Persistence / Transaction (`persistence`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-PERSISTENCE-001 | 将一组持久化操作作为一个逻辑事务提交，异常时回滚。 | PTC Guide + Legacy | No | Candidate | `references/persistence/GR-PERSISTENCE-001` |
| GR-PERSISTENCE-002 | 使用 PersistableAdapter 更新 Windchill 可持久化属性。 | PTC Guide + Legacy | No | Candidate | `references/persistence/GR-PERSISTENCE-002` |
| GR-PERSISTENCE-003 | 保存或修改后按需要 refresh，避免继续持有过期状态。 | Legacy Project | No | Candidate | `references/persistence/GR-PERSISTENCE-003` |

## Query (`query`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-QUERY-001 | 按对象属性进行简单精确查询。 | Legacy Project | No | Candidate | `references/query/GR-QUERY-001` |
| GR-QUERY-002 | 安全遍历 QueryResult，并明确处理返回元素形态。 | Legacy Project | No | Candidate | `references/query/GR-QUERY-002` |
| GR-QUERY-003 | 使用 QuerySpec.appendJoin() 按 Rose/模型中定义的 Link Role 进行对象关联查询，避免手工拼接底层外键。 | PTC Guide | No | Candidate | `references/query/GR-QUERY-003` |
| GR-QUERY-004 | 使用 ClassAttribute、SQLFunction、DateExpression 与 SubSelectExpression 构造带聚合函数的子查询。 | PTC Guide | No | Candidate | `references/query/GR-QUERY-004` |
| GR-QUERY-005 | 构造 UNION/CompoundQuerySpec 时，为排序字段设置稳定 column alias，并在整体 Query 上追加 OrderBy。 | PTC Guide | No | Candidate | `references/query/GR-QUERY-005` |
| GR-QUERY-006 | Advanced Query 需要非 access-controlled execution 时，显式暴露安全边界而不是作为普通查询默认方案。 | PTC Guide | No | Candidate | `references/query/GR-QUERY-006` |

## Versioning / Working Copy (`versioning`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-VERSIONING-001 | 在业务需要最新迭代时，显式获取最新迭代。 | Legacy Project | No | Candidate | `references/versioning/GR-VERSIONING-001` |
| GR-VERSIONING-002 | 修改 Workable 对象前获取工作副本，完成后检入。 | Legacy Project | No | Candidate | `references/versioning/GR-VERSIONING-002` |

## Security Context (`security`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-SECURITY-001 | 临时调整 access enforcement，并在 finally 中恢复。 | Legacy Project | No | Candidate | `references/security/GR-SECURITY-001` |
| GR-SECURITY-002 | 需要切换 Principal 时保存原 Principal，并在 finally 中恢复。 | Legacy Project | No | Candidate | `references/security/GR-SECURITY-002` |

## Queue (`queue`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-QUEUE-001 | 按名称获取已配置的 ProcessingQueue，不存在时显式失败。 | PTC Guide + Legacy | No | Candidate | `references/queue/GR-QUEUE-001` |
| GR-QUEUE-002 | 通过 QueueHelper.manager.addEntry 提交服务端后台任务。 | PTC Guide + Legacy | No | Candidate | `references/queue/GR-QUEUE-002` |
| GR-QUEUE-003 | 调用 Windchill Queue Service 前，在最小范围内切换 Administrator 或暂时关闭 access enforcement，并可靠恢复原上下文。 | PTC Guide | No | Candidate | `references/queue/GR-QUEUE-003` |
| GR-QUEUE-004 | 设计 Queue Entry 参数时传递轻量标识/对象引用，而不是大型 List、Map 或完整业务对象图。 | PTC Guide | No | Candidate | `references/queue/GR-QUEUE-004` |

## Service (`service`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-SERVICE-001 | 通过 Helper 暴露静态 service 入口，并用 @RemoteInterface 声明可由 Windchill ServiceFactory 获取的服务接口。 | PTC Guide | No | Candidate | `references/service/GR-SERVICE-001` |
| GR-SERVICE-002 | 实现 Windchill service 时继承 StandardManager、实现 service interface，并提供 static factory 完成 initialize。 | PTC Guide | No | Candidate | `references/service/GR-SERVICE-002` |
| GR-SERVICE-003 | 将自定义 StandardManager service 注册到 Windchill service configuration，并通过 xconfmanager 传播。 | PTC Guide | No | Candidate | `references/service/GR-SERVICE-003` |

## Listener / Event (`listener`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-LISTENER-001 | 在 StandardManager/Service 启动阶段集中注册事件监听。 | Legacy Project | No | Candidate | `references/listener/GR-LISTENER-001` |
| GR-LISTENER-002 | 统一检查 KeyedEvent，再按 eventType 和 target 分派。 | Legacy Project | No | Candidate | `references/listener/GR-LISTENER-002` |
| GR-LISTENER-003 | 监听 WTDocument 修订事件，并从 VersionControlServiceEvent 获取新迭代。 | Legacy Project | No | Candidate | `references/listener/GR-LISTENER-003` |
| GR-LISTENER-004 | 监听 EPM Workspace checkin，并对 EPMDocument 做轻量分派。 | Legacy Project | Yes | Candidate | `references/listener/GR-LISTENER-004` |
| GR-LISTENER-005 | 在 StandardManager startup 阶段通过 ManagerService.addEventListener 注册 ServiceEventListenerAdapter，并仅在目标 veto event 中执行轻量校验。 | PTC Guide | No | Candidate | `references/listener/GR-LISTENER-005` |

## BOM / Structure (`bom`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-BOM-001 | 使用 WTPartHelper.service.getUsesWTParts 遍历直接子件及 UsageLink。 | Legacy Project | No | Candidate | `references/bom/GR-BOM-001` |
| GR-BOM-002 | 在父件工作副本上创建 UsageLink，并复制数量/单位。 | Legacy Project | No | Candidate | `references/bom/GR-BOM-002` |
| GR-BOM-003 | 找到目标 UsageLink 后从父件 Working Copy 的结构中移除。 | Legacy Project | No | Candidate | `references/bom/GR-BOM-003` |
| GR-BOM-004 | 从已有 UsageLink 复制数量和单位到新 Link。 | Legacy Project | No | Candidate | `references/bom/GR-BOM-004` |

## Content (`content`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-CONTENT-001 | 在事务中删除旧 Primary Content 并上传新的 ApplicationData。 | Legacy Project | No | Candidate | `references/content/GR-CONTENT-001` |

## Workflow (`workflow`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-WORKFLOW-001 | 读取 TeamManaged 对象的流程团队，并按 Role 统计参与者。 | Legacy Project | No | Candidate | `references/workflow/GR-WORKFLOW-001` |
| GR-WORKFLOW-002 | 从 WorkItem 获取 Activity 和 Primary Business Object。 | Legacy Project | No | Candidate | `references/workflow/GR-WORKFLOW-002` |
| GR-WORKFLOW-003 | 通过 WorkflowHelper.service.delegate 执行工作流任务转办。 | Javadoc-corrected Legacy | No | Candidate | `references/workflow/GR-WORKFLOW-003` |

## Team (`team`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-TEAM-001 | 读取用户在 Container Team 中的角色，并按角色添加成员。 | Legacy Project | No | Candidate | `references/team/GR-TEAM-001` |

## Lifecycle (`lifecycle`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-LIFECYCLE-001 | 通过 LifeCycleHelper 设置对象生命周期状态。 | Legacy Project | No | Candidate | `references/lifecycle/GR-LIFECYCLE-001` |

## Change (`change`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-CHANGE-001 | 通过结构化查询查找 WTChangeOrder2。 | Legacy Project | No | Candidate | `references/change/GR-CHANGE-001` |

## JCA / UI (`ui`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-UI-001 | JCA Action Filter 根据 WorkItem/Activity/PBO 返回 ENABLED 或 HIDDEN。 | Legacy Project | No | Candidate | `references/ui/GR-UI-001` |
| GR-UI-002 | AbstractDataUtility 返回预填值 TextBox，并使用标准列名。 | Legacy Project | No | Candidate | `references/ui/GR-UI-002` |
| GR-UI-003 | AbstractComponentBuilder 分离 TableConfig 与 Data 构建。 | Legacy Project | No | Candidate | `references/ui/GR-UI-003` |
| GR-UI-004 | FormProcessor 从 NmCommandBean 获取选择对象并返回 FormResult。 | Legacy Project | No | Candidate | `references/ui/GR-UI-004` |
| GR-UI-005 | 使用 AbstractComponentBuilder 将 table configuration 与 table data 分开构建，并通过 ComponentConfigFactory 创建 TableConfig/ColumnConfig。 | PTC Guide | No | Candidate | `references/ui/GR-UI-005` |
| GR-UI-006 | 使用 AbstractAttributesComponentBuilder/ComponentConfigFactory 创建 AttributePanelConfig，并将属性分组组织。 | PTC Guide | No | Candidate | `references/ui/GR-UI-006` |
| GR-UI-007 | 当标准 DataUtility 不能满足显示需求时继承 AbstractDataUtility，并把批量数据预取放到 setModelData()，避免在每个 cell 的 getDataValue() 中重复查询。 | PTC Guide | No | Candidate | `references/ui/GR-UI-007` |
| GR-UI-008 | 通过 service XCONF 注册自定义 DataUtility selector，并在 ColumnConfig 上显式 setDataUtilityId。 | PTC Guide | No | Candidate | `references/ui/GR-UI-008` |

## UI Validation (`validator`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-VALIDATOR-001 | 继承 DefaultUIComponentValidator，通过 pre-validation 返回 ENABLED / DISABLED / HIDDEN，控制 Action/UI component 是否可见和可用。 | PTC Guide | No | Candidate | `references/validator/GR-VALIDATOR-001` |
| GR-VALIDATOR-002 | 对用户已经选择的 Action 执行 post-select validation，返回 PERMITTED、DENIED 或 PROMPT_FOR_CONFIRMATION。 | PTC Guide | No | Candidate | `references/validator/GR-VALIDATOR-002` |
| GR-VALIDATOR-003 | 在 validateFormSubmission() 中进行 MethodServer 侧表单校验，并用 PERMITTED / DENIED 与 FeedbackMessage 控制 wizard 下一步或提交。 | PTC Guide | No | Candidate | `references/validator/GR-VALIDATOR-003` |

## Configuration / Customization Management (`config`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-CONFIG-001 | 新增 service provider property file 时，通过自定义 declarative XCONF 把文件追加到 Windchill customPropertyFiles，而不是直接编辑 wt.properties。 | PTC Guide | No | Candidate | `references/config/GR-CONFIG-001` |
| GR-CONFIG-002 | 当官方定制机制确实要求修改 PTC 提供文件时，在 wtSafeArea/ptcOrig 保留原始文件，并在 wtSafeArea/siteMod 保存站点修改版本。 | PTC Guide | No | Candidate | `references/config/GR-CONFIG-002` |
| GR-CONFIG-003 | 新增公司自定义 Java package 时使用公司域名命名空间，并通过 xconfmanager 把 package prefix 加入 includeClassStartsWith。 | PTC Guide | No | Candidate | `references/config/GR-CONFIG-003` |
| GR-CONFIG-004 | 自定义 logical attribute 时优先创建独立 LogicalAttributesSite.xml，并通过 translatorSelectors property 指向自定义配置。 | PTC Guide | No | Candidate | `references/config/GR-CONFIG-004` |

## Configuration Specification (`configspec`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-CONFIGSPEC-001 | 实现 CustomConfigSpecDelegate，从 Edit Filter attributesMap 读取输入，在 appendSearchCriteria/process 中实现结构版本解析逻辑，并通过 service XCONF 注册。 | PTC Guide | No | Candidate | `references/configspec/GR-CONFIGSPEC-001` |
| GR-CONFIGSPEC-002 | Custom Config Spec 在 process 阶段使用 LatestConfigSpec 处理 latest/working iteration 语义。 | PTC Guide | No | Candidate | `references/configspec/GR-CONFIGSPEC-002` |

## Modeled Object (`model`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-MODEL-001 | 对 Windchill modeled/annotated class 使用 static factory + protected initialize，而不是把业务初始化逻辑塞进 constructor。 | PTC Guide | No | Candidate | `references/model/GR-MODEL-001` |

## Resource / Localization (`resource`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-RESOURCE-001 | JCA/UI label 使用 Windchill resource bundle，而不是把显示文字硬编码在 Builder/Validator/FormProcessor 中。 | PTC Guide | No | Candidate | `references/resource/GR-RESOURCE-001` |

## WRS (`wrs`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-WRS-001 | WRSCaller 用于服务端 customization 时明确 HTTP/transaction/access-control 边界及禁止使用场景。 | PTC Guide | No | Candidate | `references/wrs/GR-WRS-001` |

## XWorks (`xworks`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-XWORKS-001 | 使用 WorkflowTemplateInfo 和 AttachmentGroupDef 动态构建附件组 TableConfig。 | Legacy Project | Yes | Candidate | `references/xworks/GR-XWORKS-001` |
| GR-XWORKS-002 | XWorks listener 声明事件键、目标过滤和 veto callback。 | Legacy Project | Yes | Candidate | `references/xworks/GR-XWORKS-002` |
| GR-XWORKS-003 | XmlObject 保存时显式选择 SaveOption，控制 sub-XmlObject 的追加/替换语义。 | XWorks Guide | Yes | Candidate | `references/xworks/GR-XWORKS-003` |
| GR-XWORKS-004 | WorkflowTaskFormProcessorDelegate 在 Complete 前使用 required-condition hook 执行必须纠正的服务端校验。 | XWorks Guide | Yes | Candidate | `references/xworks/GR-XWORKS-004` |

## Type (`type`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-TYPE-001 | 通过 TypeIdentifierHelper 获取对象 Soft Type internal name。 | Legacy Project | No | Candidate | `references/type/GR-TYPE-001` |

## Document Event (`document`)

| ID | Scenario | Source | XWorks | Status | Path |
|---|---|---|---:|---|---|
| GR-DOCUMENT-001 | 从 HolderToContent 事件目标识别 WTDocument 的 Primary ApplicationData。 | Legacy Project | No | Candidate | `references/document/GR-DOCUMENT-001` |