---
id: GR-BOM-004
title: Copy Usage Link Quantity
category: bom
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Copy Usage Link Quantity

## Scenario

从已有 UsageLink 复制数量和单位到新 Link。

## Source Basis

- Source-B bom/processor/ExtractMBOMProcessor.java

## Review Notes

- 这只是 Quantity 基础字段；Find Number、Line Number、Reference Designator、Soft Attributes 要单独评估。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
