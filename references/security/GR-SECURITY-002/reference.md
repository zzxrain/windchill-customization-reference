---
id: GR-SECURITY-002
title: Principal Switch and Restore
category: security
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Principal Switch and Restore

## Scenario

需要切换 Principal 时保存原 Principal，并在 finally 中恢复。

## Source Basis

- Source-A epmDocument/listener/EpmDocumentListener.java
- Source-B service/StandardProjectService.java

## Review Notes

- Principal 切换必须最小化作用域。
- 更复杂的 SessionContext 场景优先使用项目已有稳定模式。
- 不能把管理员切换作为普通权限问题的默认解决方案。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
