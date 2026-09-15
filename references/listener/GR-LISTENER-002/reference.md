---
id: GR-LISTENER-002
title: Keyed Event Dispatch
category: listener
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Keyed Event Dispatch

## Scenario

统一检查 KeyedEvent，再按 eventType 和 target 分派。

## Source Basis

- Source-B part/listener/PartListenerServiceAdapter.java
- Source-B doc/listener/DocumentListenerServiceAdapter.java

## Review Notes

- 先过滤事件类型和目标类型。
- 避免 listener 内递归 modify 导致重复事件。
- 通知顺序不应作为业务逻辑前提。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
