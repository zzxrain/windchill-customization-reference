---
id: GR-UI-008
title: DataUtility Registration and Column Binding
category: ui
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# DataUtility Registration and Column Binding

## Scenario

通过 service XCONF 注册自定义 DataUtility selector，并在 ColumnConfig 上显式 setDataUtilityId。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Specifying Datautility for Columns, pp. 600-601.

## Review Notes

- DataUtility selector 应使用稳定、企业命名空间内的 ID。
- XCONF 是配置源，不要仅修改生成后的 `service.properties`。
- Builder 中只绑定 selector，不直接 `new DataUtility`。
- DataUtility 如果使用实例字段保存 `setModelData()` 阶段准备的数据，必须确认注册生命周期不会让无关请求共享这份可变状态。
- 本 Reference 的 `datautility-service.xconf` 示例使用 `cardinality="duplicate"`，用于展示每次获取独立 DataUtility 实例的注册模式；目标项目仍应依据目标 Windchill 版本确认实际生命周期语义。
- `GR-UI-007` 中的实例缓存模式和本 Reference 的注册模式应作为一个完整生命周期问题一起评估，而不是只复制其中一半。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 如果 DataUtility 使用实例字段缓存预取数据，应同时阅读 `GR-UI-007` 并确认线程安全和生命周期。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。