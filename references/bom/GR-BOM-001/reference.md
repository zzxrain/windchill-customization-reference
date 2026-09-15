---
id: GR-BOM-001
title: Traverse WTPart Usage Links
category: bom
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Traverse WTPart Usage Links

## Scenario

使用 WTPartHelper.service.getUsesWTParts 遍历直接子件及 UsageLink。

## Source Basis

- Source-B bom/processor/ExtractMBOMProcessor.java
- Source-B bom/BOMHelper.java
- Source-C bom/BOMHelper.java

## Review Notes

- ConfigSpec 决定结构语义，必须来自业务场景。
- 不要默认把直接子件遍历当成完整递归 BOM。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
