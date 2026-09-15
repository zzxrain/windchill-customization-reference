---
id: GR-QUERY-006
title: Advanced Query Access-Control Boundary
category: query
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Advanced Query Access-Control Boundary

## Scenario

只有在 QuerySpec 使用高级查询特性且普通 `find()` 无法执行时，才启用 advanced query，并把非 access-controlled `query()` 的安全影响显式暴露给调用方。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Advanced Query Capabilities, compound query execution and Access Control Consideration, pp. 2463-2465.

## Review Notes

- Guide 指出某些 advanced feature statement 需要 `setAdvancedQueryEnabled(true)` 并使用非 access-controlled `query()` 执行。
- 这不是普通查询的推荐默认值；调用方必须明确安全边界和结果可见性。
- 能用 `PersistenceHelper.manager.find()`/平台业务 API 表达的查询，不应为了方便切换到非 access-controlled query。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的定制模式为主要依据，并做了最小化、去业务化和必要注释规范化。
- `guide-derived` 表示来源有文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认 Project `AGENTS.md` 中的 Windchill Version、XWorks 状态、项目架构和适用场景。
- 精确 PTC/XWorks Class、Method、Signature 与 Supported/Extendable 状态应通过目标版本 Javadoc、XWorks Javadoc 或实际项目依赖再次确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
