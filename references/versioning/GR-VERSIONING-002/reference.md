---
id: GR-VERSIONING-002
title: Checkout / Working Copy / Checkin
category: versioning
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Checkout / Working Copy / Checkin

## Scenario

修改 Workable 对象前获取工作副本，完成后检入。

## Source Basis

- Source-A part/PartHelper.java
- Source-B bom/processor/ExtractMBOMProcessor.java

## Review Notes

- Checkout/checkin 是平台业务语义，不应直接用 Persistence modify 替代。
- 异常路径下是否保留 checkout 需由业务决定，不要自动 undo checkout。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
