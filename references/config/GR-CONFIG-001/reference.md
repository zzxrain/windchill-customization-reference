---
id: GR-CONFIG-001
title: Declarative XCONF for Custom Service Provider File
category: config
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Declarative XCONF for Custom Service Provider File

## Scenario

新增 service provider property file 时，通过自定义 declarative XCONF 把文件追加到 Windchill customPropertyFiles，而不是直接编辑 wt.properties。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Adding a Custom Service Provider Property File, pp. 154-155.

## Review Notes

- 这是避免和后续 PTC 产品/维护更新冲突的标准模式。
- 新 XCONF 自身应作为源码资产管理。
- 安装时用 xconfmanager `-i ... -p`。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
