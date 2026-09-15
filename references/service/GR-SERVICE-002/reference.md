---
id: GR-SERVICE-002
title: StandardManager Service Implementation
category: service
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# StandardManager Service Implementation

## Scenario

实现 Windchill service 时继承 StandardManager、实现 service interface，并提供 static factory 完成 initialize。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, System Generation, Listing 19, p. 2264.

## Review Notes

- 使用静态 `newStandard...()` factory，而不是由调用方直接 new service。
- service 方法应封装完整业务操作和事务边界，而不是暴露零散 persistence 操作。
- 示例方法体故意保持最小。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
