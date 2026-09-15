---
id: GR-SERVICE-001
title: ServiceFactory Helper and Remote Interface
category: service
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# ServiceFactory Helper and Remote Interface

## Scenario

通过 Helper 暴露静态 service 入口，并用 @RemoteInterface 声明可由 Windchill ServiceFactory 获取的服务接口。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, System Generation, Listings 17-18, p. 2263.

## Review Notes

- Helper 应是静态入口，不承担业务状态。
- Service interface 的方法需要按 Windchill service contract 抛出 WTException。
- 具体服务实现与注册见后续 Reference。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
