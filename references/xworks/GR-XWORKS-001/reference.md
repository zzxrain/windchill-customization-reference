---
id: GR-XWORKS-001
title: XWorks Attachment Group Table Config
category: xworks
status: candidate
windchill: multi-version-candidate
xworks: true
verification: source-derived-not-runtime-verified
---

# XWorks Attachment Group Table Config

## Scenario

使用 WorkflowTemplateInfo 和 AttachmentGroupDef 动态构建附件组 TableConfig。

## Source Basis

- Source-C ptc/xworks/examples/taskform/ExampleAttachmentGroupTableConfigBuilder.java

## Review Notes

- 仅适用于明确启用 XWorks 的项目。
- XWorks API/annotation 需要按项目实际 Jar/Javadoc 验证。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
