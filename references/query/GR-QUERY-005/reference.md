---
id: GR-QUERY-005
title: Compound Query with Stable Sort Alias
category: query
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Compound Query with Stable Sort Alias

## Scenario

构造 UNION/CompoundQuerySpec 时，为排序字段设置稳定 column alias，并在整体 Query 上追加 OrderBy。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Advanced Query Capabilities, sorting and compound query example, p. 2463.

## Review Notes

- Guide 强调 compound query 各 component select 列数/类型必须兼容。
- OrderBy 使用的 ColumnExpression 建议设置 column alias，且 alias 不要使用 SQL reserved word。
- Advanced query 执行可能绕过 access control；不要把 `PersistenceHelper.manager.query()` 当普通查询默认方案。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
