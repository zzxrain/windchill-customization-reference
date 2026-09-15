---
id: GR-UI-007
title: Custom DataUtility with Column Prefetch
category: ui
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom DataUtility with Column Prefetch

## Scenario

当标准 DataUtility 不能满足显示需求时继承 AbstractDataUtility，并把批量数据预取放到 setModelData()，避免在每个 cell 的 getDataValue() 中重复查询。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Data Utilities, pp. 678-679.

## Review Notes

- Guide 明确提醒避免在 `getDataValue()` 中做数据库查询。
- 表格列需要外部数据时，优先在 `setModelData()` 中针对待处理对象集合执行一次或少量批量加载，再由 `getDataValue()` 从已准备的数据中读取。
- 不要把批量预取机械限定为“一次 IN 查询”；具体查询方式应根据数据量、查询条件、数据库限制和 Windchill API 语义决定。
- `setModelData()` 用于针对当前 DataUtility / Column 所处理的一组对象准备数据，不应描述为“整个 Table 永远只调用一次”；精确调用生命周期以目标版本 Framework 行为为准。
- 如果像本 Reference 示例一样把预取结果保存在 DataUtility 实例字段中，必须同时确认 DataUtility 的实例生命周期不会让多个请求共享这份可变状态。
- 当前 Repository 的 `GR-UI-008` 展示了 DataUtility 注册和 Column Binding；其示例使用 `cardinality="duplicate"`。采用实例字段缓存模式时，应同时检查对应注册和生命周期配置。
- 如果已有 OOTB DataUtility 可扩展，应优先复用现有实现。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 如果实现使用 DataUtility 实例字段保存请求级或列级预取结果，应同时检查 `GR-UI-008` 或项目已有 DataUtility 注册方式。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。