---
id: GR-LISTENER-005
title: StandardManager Event Subscription with Veto Listener
category: listener
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# StandardManager Event Subscription with Veto Listener

## Scenario

在 StandardManager startup 阶段通过 ManagerService.addEventListener 注册 ServiceEventListenerAdapter，并仅在目标 veto event 中执行轻量校验。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Creating Non-Modeled Services for Listening / Service Event Subscription, pp. 2362-2364 and 2374.

## Review Notes

- Listener subscription 在服务启动阶段集中完成。
- veto listener 只做必要校验，不应执行长耗时外部调用。
- 事件 key 和 target 类型必须精确匹配目标事件语义。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
