---
id: GR-CONFIG-003
title: Custom Package Namespace Registration
category: config
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom Package Namespace Registration

## Scenario

新增公司自定义 Java package 时使用公司域名命名空间，并通过 xconfmanager 把 package prefix 加入 includeClassStartsWith。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Best Practices for Adding New Packages and Files, pp. 152-153.

## Review Notes

- 自定义 package 不应放在 `wt.*` 或 `com.ptc.*` 下。
- includeClassStartsWith 的 package prefix 末尾必须包含 `.`。
- 命令属于部署/安装步骤，不应在应用运行时执行。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
