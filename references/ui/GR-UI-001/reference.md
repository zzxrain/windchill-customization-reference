---
id: GR-UI-001
title: WorkItem-aware Action Filter
category: ui
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# WorkItem-aware Action Filter

## Scenario

JCA Action Filter 根据 WorkItem/Activity/PBO 返回 ENABLED 或 HIDDEN。

## Source Basis

- Source-B part/validation/HideForEditMaterialAttributeValidator.java

## Review Notes

- Validator 控制 UI 可见性/可用性，不是服务端授权边界。
- Fail-open/Fail-closed 策略按具体动作风险决定。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
