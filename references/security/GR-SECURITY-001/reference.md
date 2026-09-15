---
id: GR-SECURITY-001
title: Access Enforcement Scope
category: security
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Access Enforcement Scope

## Scenario

临时调整 access enforcement，并在 finally 中恢复。

## Source Basis

- Source-A tool/doc/service/UploadDocumentContent.java
- Source-B workflow/process/ReassignFormProcessor.java

## Review Notes

- 禁用 ACL 检查属于高风险操作，只用于明确的服务端受控场景。
- 必须恢复原值，禁止遗漏 finally。
- UI Validator 不能替代这里的安全校验。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
