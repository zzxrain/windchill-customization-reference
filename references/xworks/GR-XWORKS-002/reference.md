---
id: GR-XWORKS-002
title: XWorks Vetoable Event Listener
category: xworks
status: candidate
windchill: multi-version-candidate
xworks: true
verification: source-derived-not-runtime-verified
---

# XWorks Vetoable Event Listener

## Scenario

XWorks listener 声明事件键、目标过滤和 veto callback。

## Source Basis

- Source-C ptc/xworks/examples/listener/InsertSubPartInPSBListener.java
- Source-A epmDocument/listener/EpmDocumentListener.java

## Review Notes

- 不要复制通过 StackTrace 判断 PSB 调用来源的脆弱历史模式。
- 监听内抛异常可能影响发起事务，必须谨慎。
- 仅适用于 XWorks 项目。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
