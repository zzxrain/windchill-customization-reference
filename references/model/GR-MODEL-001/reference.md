---
id: GR-MODEL-001
title: Modeled Class Factory and Initialize Pattern
category: model
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Modeled Class Factory and Initialize Pattern

## Scenario

对 Windchill modeled/annotated class 使用 static factory + protected initialize，而不是把业务初始化逻辑塞进 constructor。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, System Generation, factory/initialize pair example, pp. 2252-2253.

## Review Notes

- Windchill externalization 需要廉价 no-arg construction，因此使用 factory pattern。
- static factory 负责 new + 调 initialize + return；参数处理放在 initialize，便于子类继承。
- modeled class 还涉及生成、SQL、升级/外部化规则；不能只复制此片段就完成数据模型扩展。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
