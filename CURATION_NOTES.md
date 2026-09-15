# Curation Notes

## 输入

本候选库基于：

1. 用户提供的三个历史 Windchill 项目代码库；
2. PTC Windchill 13.1.2.0 Customization Guide。

## 本轮新增

- 新增 PTC Guide-derived Reference，重点覆盖 QuerySpec 高级查询、Queue 安全边界、Service/StandardManager、Event Listener、MVC Builder、DataUtility、UI Validator、XCONF/customization management、Modeled Object factory pattern、Custom Configuration Spec 与资源国际化。
- 保留模块独立流水 ID，新条目只在所属模块末尾递增。
- `CATALOG.md` 增加 Source 列，用于区分 `PTC Guide` 和 `Legacy Project`。
- Guide-derived 示例做了最小化和去示例业务化，避免把 Pet/Acme 等教学业务直接当作企业 Golden Code。

## 本轮仍未执行

- 不编译。
- 不部署 Windchill。
- 不执行 Runtime Verification。
- 不宣称所有 Guide 示例中的 API 在其他 Windchill 版本保持相同。

## Review 建议

人工 Review 时优先：

1. `query` / `persistence` / `versioning` / `security`
2. `service` / `listener` / `queue`
3. `ui` / `validator` / `resource`
4. `config` / `configspec` / `model`
5. 业务模块与 `xworks`

对于历史项目和 PTC Guide 出现冲突的场景，不应简单二选一；先确认当前 Windchill Version、官方扩展机制和项目兼容要求，再决定最终 Approved Pattern。

## 第二轮质量修正与扩展

- 对历史 Queue Reference 按 13.1.2.0 Guide/Javadoc 做纠偏：不再保留 `QueueHelper.manager.createQueue(...)` 和 `ProcessingQueue.addEntry(...)` 作为推荐模式，改为 preconfigured queue lookup + service-layer `QueueHelper.manager.addEntry(...)`。
- 修正历史候选中的明显 package/signature 问题：`wt.vc.Iterated`、`wt.lifecycle.LifeCycleManaged`、`WorkflowHelper.service.delegate(...)`。
- 将 Transaction / PersistableAdapter 的历史模式补充为 `PTC Guide + Legacy` 双来源。
- 新增 Advanced Query 安全边界、Custom Config Spec latest/working iteration、WRSCaller 使用边界。
- 新增 XWorks `SaveOption` 与 Workflow Form required validation 两个高价值候选。

仍然未执行 Windchill/XWorks Runtime Verification。
