---
id: GR-QUERY-003
title: QuerySpec Modeled Join
category: query
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# QuerySpec Modeled Join

## Scenario

使用 QuerySpec.appendJoin() 按 Rose/模型中定义的 Link Role 进行对象关联查询，避免手工拼接底层外键。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Advanced Query Capabilities, Join Support, pp. 2463-2464.

## Review Notes

- Guide 明确提供 appendJoin(linkIndex, role, targetIndex) 的 modeled join 模式。
- 示例只演示查询结构；实际返回字段、ACL 语义和数据量需按项目场景决定。
- 不要为了 Join 方便直接退回 JDBC/原生 SQL。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
