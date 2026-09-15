---
id: GR-DOCUMENT-001
title: Primary Content Event Target
category: document
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Primary Content Event Target

## Scenario

从 HolderToContent 事件目标识别 WTDocument 的 Primary ApplicationData。

## Source Basis

- Source-B doc/listener/DocumentListenerServiceAdapter.java

## Review Notes

- HolderToContent 事件和 Document 事件是不同目标形态，listener 要先辨别 target。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
