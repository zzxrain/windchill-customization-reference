---
id: GR-BOM-003
title: Remove WTPartUsageLink
category: bom
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Remove WTPartUsageLink

## Scenario

找到目标 UsageLink 后从父件 Working Copy 的结构中移除。

## Source Basis

- Source-B bom/processor/ExtractMBOMProcessor.java

## Review Notes

- 删除前应确认 link 唯一标识和目标结构视图。
- 不要仅以 child number 作为唯一 UsageLink 标识。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
