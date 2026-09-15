---
id: GR-QUEUE-004
title: Lightweight Queue Arguments
category: queue
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Lightweight Queue Arguments

## Scenario

设计 Queue Entry 参数时传递轻量标识/对象引用，而不是大型 List、Map 或完整业务对象图。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Performance Impact of Large Serialized Queue Arguments / Best Practices for Configuring Queue Entry Arguments, p. 158.

## Review Notes

- Guide 建议控制序列化参数体积，复杂/大型数据优先持久化后传 ObjectReference。
- Queue task 执行时再按引用读取最新对象状态。
- 不要在 Queue Entry 中塞大型对象集合。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
