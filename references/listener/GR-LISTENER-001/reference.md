---
id: GR-LISTENER-001
title: Standard Service Listener Registration
category: listener
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Standard Service Listener Registration

## Scenario

在 StandardManager/Service 启动阶段集中注册事件监听。

## Source Basis

- Source-B service/StandardProjectService.java

## Review Notes

- 示例展示集中注册思路；具体基类/Listener 类型按项目和目标版本确认。
- 监听回调通常与事件发起线程/事务有耦合，应避免长耗时。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
