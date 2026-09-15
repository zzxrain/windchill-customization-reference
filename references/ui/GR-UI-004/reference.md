---
id: GR-UI-004
title: DefaultObjectFormProcessor
category: ui
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# DefaultObjectFormProcessor

## Scenario

FormProcessor 从 NmCommandBean 获取选择对象并返回 FormResult。

## Source Basis

- Source-B workflow/process/ReassignFormProcessor.java
- Source-C risk/processor/RiskItemAttachmentFormProcessor.java

## Review Notes

- FormProcessor 负责请求编排，不建议承载大型业务逻辑。
- 服务端必须重复关键安全/业务校验，不能仅依赖页面 Validator。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
