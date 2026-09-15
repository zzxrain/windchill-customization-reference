---
id: GR-LISTENER-003
title: Document New Version Listener
category: listener
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Document New Version Listener

## Scenario

监听 WTDocument 修订事件，并从 VersionControlServiceEvent 获取新迭代。

## Source Basis

- Source-B doc/listener/DocumentListenerServiceAdapter.java

## Review Notes

- 修订监听中 predecessor/current 的版本语义要显式。
- 示例中的返回类型应以目标版本 API Lookup 为准。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
