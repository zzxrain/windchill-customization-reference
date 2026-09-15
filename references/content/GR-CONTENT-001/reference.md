---
id: GR-CONTENT-001
title: Replace Primary Content
category: content
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Replace Primary Content

## Scenario

在事务中删除旧 Primary Content 并上传新的 ApplicationData。

## Source Basis

- Source-A tool/doc/service/UploadDocumentContent.java

## Review Notes

- InputStream 生命周期由调用方明确管理。
- 是否禁用 ACL 必须是显式安全决策，不要默认关闭访问控制。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
