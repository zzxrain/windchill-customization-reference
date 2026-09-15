---
id: GR-QUEUE-002
title: Enqueue Method Invocation via Queue Service
category: queue
status: candidate
windchill: 13.1.2.0-verified-api-pattern
xworks: false
verification: guide-and-javadoc-derived-not-runtime-verified
provenance: legacy-normalized-with-ptc-guide-correction
---

# Enqueue Method Invocation via Queue Service

## Scenario

通过 `QueueHelper.manager.addEntry(...)` 把服务端静态方法调用提交到 ProcessingQueue。

## Source Basis

- 历史项目 QueueUtil 实现。
- PTC Windchill 13.1.2.0 Customization Guide, Windchill APIs for Queue Management Customizations。
- Windchill 13.1.2.0 Javadoc: `wt.queue.QueueService#addEntry(ProcessingQueue, WTPrincipal, String, String, Class[], Object[])`。

## Review Notes

- PTC Guide 明确说明 Queue API 的 supportability 已从部分 object-model API 转移到 service layer；因此不再保留 `queue.addEntry(...)` 作为 Golden Pattern。
- 被调用方法必须适合 Queue 反射调用，参数类型与参数值必须匹配。
- 参数应尽量轻量；大型对象图应改为持久化后传 ObjectReference/标识。
- 业务事务与 Queue 提交边界必须明确。

## Agent Guidance

- 优先调用 `QueueHelper.manager` 的 service API。
- 精确 Method Signature 必须按目标版本 Javadoc / API Lookup 验证。
- 不要因为历史代码能运行就继续复制 object-model 层旧式 Queue API。
