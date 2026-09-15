---
name: windchill-golden-reference
description: 当 Windchill 二次开发任务需要企业批准/候选实现模式、PTC Customization Guide 典型扩展模式或历史项目可复用范式时使用。优先从 CATALOG.md 按模块选择最相关的 1～3 个 Reference，不要全量加载。
---

# Windchill Golden Reference Skill

## When to use

当任务需要回答“同类 Windchill 定制通常怎么实现”时使用。

## Source Preference

如果同一场景同时存在两种来源：

1. `PTC Guide`：优先用于理解官方扩展机制、生命周期和推荐集成点。
2. `Legacy Project`：用于补充真实项目中的工程化实现、兼容方式和常见上下文。

不要因为条目来自 PTC Guide 就跳过目标版本 Javadoc/API Lookup；Guide-derived 仍可能包含版本敏感或 Supported=false 的 API。

## Reference ID

Reference ID 使用模块独立流水：

```text
GR-<MODULE>-<NNN>
```

ID 是稳定标识，不因 Catalog 排序或新增重新编号。

## Workflow

1. 读取 Project `AGENTS.md`。
2. 确认 Windchill Version 和 `XWorks Enabled`。
3. 读取 `CATALOG.md`。
4. 先按模块定位，再按 Scenario / Source / XWorks 筛选 1～3 个 Reference。
5. 优先考虑 `PTC Guide` 来源的官方扩展模式，再按需读取历史项目候选。
6. 读取对应 `reference.md` 和 `src/*`。
7. 将 Reference 作为实现模式，不机械复制示例业务。
8. 精确 PTC API 使用 `windchill-api-lookup` 验证。
9. 如 Reference 与 Rules / Project ADR / Approved Exception 冲突，服从更高优先级约束。

## Candidate Policy

当前条目初始状态均为 `candidate`，本轮未做 Runtime Verification。

Candidate 可以用于设计参考、模式识别和初始代码生成，但不应描述为目标项目已经运行验证。

## XWorks

只有 Project Context 明确 `XWorks Enabled: true` 时，才允许选择 `xworks: true` 的 Reference。
