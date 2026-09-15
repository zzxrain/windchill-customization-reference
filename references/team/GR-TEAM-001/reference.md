---
id: GR-TEAM-001
title: Container Team Role Membership
category: team
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Container Team Role Membership

## Scenario

读取用户在 Container Team 中的角色，并按角色添加成员。

## Source Basis

- Source-C base/util/TeamUtil.java

## Review Notes

- Role 是否已存在、fallback 到 MEMBERS 等策略应由项目决定。
- 修改 Container Team 时考虑访问控制和审计要求。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
