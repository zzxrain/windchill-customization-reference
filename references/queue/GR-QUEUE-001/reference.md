---
id: GR-QUEUE-001
title: Lookup Preconfigured ProcessingQueue
category: queue
status: candidate
windchill: 13.1.2.0-verified-api-pattern
xworks: false
verification: guide-and-javadoc-derived-not-runtime-verified
provenance: legacy-normalized-with-ptc-guide-correction
---

# Lookup Preconfigured ProcessingQueue

## Scenario

按名称获取已配置的 ProcessingQueue；如果不存在则显式失败，而不是在普通业务请求中静默创建后台队列。

## Source Basis

- 历史项目 QueueUtil 实现。
- PTC Windchill 13.1.2.0 Customization Guide, Windchill APIs for Queue Management Customizations。
- Windchill 13.1.2.0 Javadoc: `wt.queue.QueueService#getQueue(String)`。

## Review Notes

- 历史项目中的 `QueueHelper.manager.createQueue(...)` 不作为 Golden Pattern 保留。
- Queue lifecycle/configuration 更适合由部署、初始化或管理员受控处理，业务代码优先消费已经配置好的 Queue。
- Queue Name 应配置化；找不到 Queue 时应暴露明确错误，不要自动换用其他 Queue。

## Agent Guidance

- 优先使用 `QueueHelper.manager` 暴露的 Queue service API，而不是直接依赖 Queue object-model 的旧式管理方法。
- 精确 API 仍应通过目标版本 Javadoc / API Lookup 验证。
- 如项目确实要求程序化创建 Queue，应单独设计初始化/部署流程并进行版本验证，不要把创建逻辑隐藏在普通 enqueue helper 中。
