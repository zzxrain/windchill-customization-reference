---
id: GR-BOM-002
title: Create WTPartUsageLink
category: bom
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Create WTPartUsageLink

## Scenario

在父件工作副本上创建 UsageLink，并复制数量/单位。

## Source Basis

- Source-B bom/processor/ExtractMBOMProcessor.java
- Source-C bom/load/BomLoadHelper.java

## Review Notes

- parent 应是可修改的正确 Working Copy。
- Quantity Unit、Find Number、Line Number、IBA 等按项目语义显式处理。
- PersistenceServerHelper 使用需结合 ACL/服务层边界评估。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
