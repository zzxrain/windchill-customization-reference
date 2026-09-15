---
id: GR-QUEUE-003
title: Queue Service Security Scope
category: queue
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Queue Service Security Scope

## Scenario

调用 Windchill Queue Service 前，在最小范围内切换 Administrator 或暂时关闭 access enforcement，并可靠恢复原上下文。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Customization with Windchill Queues, pp. 157-158.

## Review Notes

- Guide 明确指出 Queue public API 有 access-control checks。
- 这是 Queue 场景的特定要求，不应推广成通用“遇到权限问题就提权”。
- 恢复安全上下文必须放在 finally。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
