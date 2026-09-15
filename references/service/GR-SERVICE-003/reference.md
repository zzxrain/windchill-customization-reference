---
id: GR-SERVICE-003
title: Custom Service Registration via XCONF
category: service
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom Service Registration via XCONF

## Scenario

将自定义 StandardManager service 注册到 Windchill service configuration，并通过 xconfmanager 传播。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, System Generation, Listing 20, p. 2264.

## Review Notes

- Service numeric slot/registration key 必须避免覆盖已有服务。
- 不要直接修改生成后的 wt.properties 作为唯一配置源。
- 真实项目应采用公司统一的 custom XCONF/部署策略。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
