---
id: GR-LISTENER-004
title: EPM Workspace Checkin Listener
category: listener
status: candidate
windchill: multi-version-candidate
xworks: true
verification: source-derived-not-runtime-verified
---

# EPM Workspace Checkin Listener

## Scenario

监听 EPM Workspace checkin，并对 EPMDocument 做轻量分派。

## Source Basis

- Source-A epmDocument/listener/EpmDocumentListener.java
- Source-B epm/listener/EPMDocumentListenerServiceAdapter.java

## Review Notes

- 这是 XWorks listener 形态，只在项目明确启用 XWorks 时使用。
- com.ptc.xworks.* 不是公共 PTC Supported API；按项目版本验证。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
