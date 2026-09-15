---
id: GR-PERSISTENCE-002
title: PersistableAdapter Attribute Update
category: persistence
status: candidate
windchill: multi-version-candidate
xworks: false
verification: guide-and-source-derived-not-runtime-verified
provenance: legacy-normalized-confirmed-by-ptc-guide
---

# PersistableAdapter Attribute Update

## Scenario

使用 PersistableAdapter 更新 Windchill 可持久化属性。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide。
- Source-B util/AttributeUtil.java
- Source-A utils/PersistenceUtil.java

## Review Notes

- PTC Customization Guide 在 Change Management attribute customization 中使用 `PersistableAdapter.load/set/apply` 后再持久化修改。
- PTC Customization Guide 在 Change Management attribute customization 中使用 `PersistableAdapter.load/set/apply` 后再持久化修改。
- 属性 internal name 必须来自项目/类型定义，不要由模型猜测。
- Workable 对象修改前应先检查 Working Copy 语义。
- Locale/OperationIdentifier 选择需结合实际场景。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
