---
id: GR-PERSISTENCE-003
title: Save / Modify / Refresh Boundary
category: persistence
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Save / Modify / Refresh Boundary

## Scenario

保存或修改后按需要 refresh，避免继续持有过期状态。

## Source Basis

- Source-A utils/PersistenceUtil.java
- Source-C change/ChangeProcessHelper.java

## Review Notes

- 不要把 save/modify 机械混用；根据对象生命周期和 Windchill 服务语义选择。
- 多个操作需要原子性时配合 Transaction。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
