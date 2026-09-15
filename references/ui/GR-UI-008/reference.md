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
- XCONF 是配置源，不要仅修改生成后的 service.properties。
- Builder 中只绑定 selector，不直接 new DataUtility。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
