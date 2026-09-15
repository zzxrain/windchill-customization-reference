---
id: GR-TYPE-001
title: Type Internal Name
category: type
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Type Internal Name

## Scenario

通过 TypeIdentifierHelper 获取对象 Soft Type internal name。

## Source Basis

- Source-A epmDocument/listener/EpmDocumentListener.java
- Source-B part/validation/HideForEditMaterialAttributeValidator.java

## Review Notes

- 业务判断使用 internal name，不要依赖本地化 display name。
- Type internal name 应通过项目配置/常量管理。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
