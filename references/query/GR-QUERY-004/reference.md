---
id: GR-QUERY-004
title: QuerySpec Subselect and Aggregate
category: query
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# QuerySpec Subselect and Aggregate

## Scenario

使用 ClassAttribute、SQLFunction、DateExpression 与 SubSelectExpression 构造带聚合函数的子查询。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, SearchCondition / Advanced Query Capabilities, pp. 2458-2460.

## Review Notes

- 适合需要 MIN/MAX 等聚合子查询且 QuerySpec 可以表达的场景。
- 子查询 alias 应显式隔离，避免和外层查询冲突。
- 高级 QuerySpec 可能触发 access-control/advanced-query 限制，执行方式需结合目标版本 Javadoc 与项目安全语义确认。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
