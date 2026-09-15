---
name: windchill-golden-reference
description: 当 Windchill 二次开发任务需要企业批准/候选实现模式、PTC Customization Guide 典型扩展模式或历史项目可复用范式时使用。优先从 CATALOG.md 选择最小充分的 1～3 个 Reference，不要全量加载。
---

# Windchill Golden Reference Skill

## When to use

当任务需要回答“同类 Windchill 定制通常怎么实现”时使用。

## Selection Preference

Reference 选择首先依据：

1. 当前任务 Scenario 是否直接匹配。
2. Project `AGENTS.md`、架构和技术栈约束是否允许。
3. Reference Status 和目标版本适用性。
4. Source Provenance。

Source Provenance 主要用于同等匹配候选之间的判断：

- `PTC Guide`：优先用于理解官方扩展机制、生命周期和推荐集成点。
- `Legacy Project`：用于补充真实项目中的工程化实现、兼容方式和常见上下文。
- `XWorks Guide`：仅在 Project Context 明确允许 XWorks 时用于 XWorks 实现模式。

不得因为 Reference 来自 `PTC Guide`，就选择一个场景匹配较弱的通用条目替代高度匹配的 Reference。

也不得因为条目来自 PTC Guide 就跳过目标版本 Javadoc / API Lookup；Guide-derived 仍可能包含版本敏感或 Supported=false 的 API。

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
4. 先按模块定位，再按 Scenario / Project Constraint / Source / XWorks 筛选候选 Reference。
5. 选择最小充分集合：如果 1 个核心 Reference 已覆盖当前任务，就只选择 1 个。
6. 只有额外 Reference 提供独立且不可替代的信息时，才增加到 2～3 个；不得为了达到数量上限而增加重复或泛化 Reference。
7. 读取最终选择的 `reference.md` 和必要的 `src/*`。
8. 将 Reference 作为实现模式，不机械复制示例业务。
9. 精确 PTC API 使用 `windchill-api-lookup` 验证。
10. 如 Reference 与 Rules / Project ADR / Approved Exception 冲突，服从更高优先级约束。

## Candidate Policy

当前条目初始状态均为 `candidate`，本轮未做 Runtime Verification。

Candidate 可以用于设计参考、模式识别和初始代码生成，但不应描述为目标项目已经运行验证。

## XWorks

只有 Project Context 明确：

```text
XWorks Enabled: true
```

时，才允许选择 `xworks: true` 的 Reference。

如果：

```text
XWorks Enabled: false
```

或无法确认 XWorks 已启用，则不得把 `xworks: true` Reference 作为实现方案。

被排除技术栈中的 Reference 最多只能用于理解通用设计思想，不得据此推导当前技术栈存在等价 Class、Method、Status 或 Hook。