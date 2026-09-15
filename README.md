# Windchill Customization Reference

本仓库是企业 Windchill Golden Reference 候选集。当前同时包含：

- 三个历史 Windchill 项目中抽取、去客户化并规范化后的可复用模式；
- PTC Windchill 13.1.2.0 Customization Guide 中整理出的典型官方定制模式；
- 用户提供的 XWorks 快速指南中整理出的 XWorks 专用候选模式。

## 当前状态

- Status: `Candidate`
- Runtime Verification: `Not Performed`
- Target Guide Baseline: `Windchill 13.1.2.0 Customization Guide`
- Total References: `62`

这些样例用于帮助 AI Agent 学习企业认可方向的实现模式，但在人工 Review 通过前，不应直接标记为 Approved Golden Reference。

## 来源分层

### PTC Guide Derived

这类 Reference 从 Windchill 13.1.2.0 Customization Guide 的典型案例中提炼，并做最小化、去示例业务化和注释规范化。

它们通常比单一历史项目代码更适合作为“默认实现方向”，但仍需：

- 根据目标 Windchill Version 做 Javadoc / API Lookup；
- 根据项目实际架构和 Rules 做适用性判断；
- 在最终 Approved 前进行人工 Review。

### XWorks Guide Derived

这类 Reference 只在项目 `AGENTS.md` 明确 `XWorks Enabled: true` 时适用，并且必须按项目实际 XWorks 版本/Javadoc 再确认 API。

### XWorks Guide Derived

这类 Reference 只在项目 `AGENTS.md` 明确 `XWorks Enabled: true` 时适用，并且必须按项目实际 XWorks 版本/Javadoc 再确认 API。

### Legacy Project Derived

这类 Reference 来自历史项目，可反映真实工程实践，但并不自动代表最佳实践。它们已经做了去客户化和部分规范化，仍需人工 Review。

## Reference ID 规则

Reference ID 使用模块独立流水：

```text
GR-<MODULE>-<NNN>
```

已有 ID 必须稳定，不因新增、删除或 Catalog 排序变化重新编号。

## 当前模块

```text
persistence
query
versioning
security
queue
service
listener
bom
content
workflow
team
lifecycle
change
ui
validator
config
configspec
model
resource
xworks
type
document
```

## Agent 使用原则

1. 先读取 `CATALOG.md`，按模块和 Scenario 选择 1～3 个 Reference。
2. 同场景同时存在 `PTC Guide` 和 `Legacy Project` 来源时，优先从 `PTC Guide` 理解官方扩展模式，再用历史项目 Reference 补充真实工程上下文。
3. 不要一次性加载整个 Reference 库。
4. 精确 PTC API 仍由目标版本 `windchill-api-lookup` 验证。
5. Project ADR / Approved Exception / Rules 优先级高于 Golden Reference。
6. `xworks: true` 的条目仅在项目明确启用 XWorks 时使用。

## 状态含义

- `candidate`: 已抽取/规范化，尚未人工批准。
- `approved`: 已由企业技术负责人 Review，可作为推荐模式。
- `deprecated`: 不再推荐，仅保留迁移/历史兼容价值。
