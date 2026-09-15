---
id: GR-UI-005
title: MVC Table Builder with ComponentConfigFactory
category: ui
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# MVC Table Builder with ComponentConfigFactory

## Scenario

使用 AbstractComponentBuilder 将 table configuration 与 table data 分开构建，并通过 ComponentConfigFactory 创建 TableConfig/ColumnConfig。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Presenting Information in the UI, pp. 580-582; Getting Started Pet Table, pp. 86-88.

## Review Notes

- 对不需要 configurable views 的普通 table，可使用 AbstractComponentBuilder。
- Column id 应优先使用稳定的 attribute/column identifiers。
- 大数据表必须避免无过滤全表 QuerySpec；本样例数据层只保留扩展点。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
