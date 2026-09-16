---
name: windchill-golden-reference
description: 当 Windchill 二次开发任务需要企业批准/候选实现模式、PTC Customization Guide 典型扩展模式或历史项目可复用范式时使用。Agent 应根据任务本身自主判断是否需要本 Skill，用户无需显式提及 Golden Reference。优先从 CATALOG.md 选择最小充分的 1～3 个 Reference，不要全量加载。
---

# Windchill Golden Reference Skill

## When to use

当任务需要回答“同类 Windchill 定制通常怎么实现”时使用。

典型场景包括：

- 新增 Windchill 二次开发实现；
- 修改已有 Windchill 定制；
- Code Review；
- Debug / Troubleshooting 中需要寻找可靠实现模式；
- 当前项目存在多种历史写法，需要选择更合适的模式；
- 需要参考 PTC Customization Guide、XWorks Guide 或经过整理的历史项目实现。

用户无需在 Prompt 中显式要求：

```text
Golden Reference
Golden Code
PTC Guide Example
Reference Pattern
```

Agent 应根据任务本身自主判断是否需要本 Skill。

如果当前任务只是普通文本修改、简单 Java 重构、明确的局部算法修改，且不依赖 Windchill 特定实现模式，则不应为了展示能力而机械调用本 Skill。

## Autonomous Invocation

Golden Reference 是 Agent 的内部实现证据源，不是要求用户直接操作的查询系统。

默认流程：

```text
User Task
    ↓
Identify implementation-pattern need
    ↓
Select Golden Reference if needed
    ↓
Apply minimum sufficient pattern
    ↓
Return task result
```

不得因为用户没有提到 Golden Reference，就跳过当前任务本应使用的 Reference。

也不得把“自主使用”理解成“所有 Windchill 请求都必须加载 Golden Reference”。

只在当前任务确实需要实现模式证据时使用。

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

1. 读取当前 Project `AGENTS.md`（如存在）。
2. 从 Project Context、用户输入或项目资料确认已知的 Windchill Version 和 `XWorks Enabled`；无法确认时不得自行猜测。
3. 读取 `CATALOG.md`。
4. 先按模块定位，再按 Scenario / Project Constraint / Source / XWorks 筛选候选 Reference。
5. 选择最小充分集合：如果 1 个核心 Reference 已覆盖当前任务，就只选择 1 个。
6. 只有额外 Reference 提供独立且不可替代的信息时，才增加到 2～3 个；不得为了达到数量上限而增加重复或泛化 Reference。
7. 读取最终选择的 `reference.md` 和必要的 `src/*`。
8. 将 Reference 作为实现模式，不机械复制示例业务。
9. 精确 PTC Class / Method / Signature / Return / Throws / Supported / Extendable / Deprecated 等 API Metadata，按需使用目标版本 Javadoc / `windchill-api-lookup` 验证。
10. Framework Behavior、生命周期、客户端交互等不能仅根据 Java Signature 或 Reference 中的代码形态推断，应使用相应目标版本官方资料或受控产品知识确认。
11. 如 Reference 与 Rules / Project ADR / Approved Exception 冲突，服从更高优先级约束。
12. Reference 无法证明的内容可以作为 Engineering Inference 提出，但必须与已确认事实区分。

## Candidate Policy

当前条目初始状态均为 `candidate`，本轮未做 Runtime Verification。

Candidate 可以用于：

- 设计参考；
- 模式识别；
- 初始代码生成；
- Code Review；
- Benchmark。

Candidate 不应描述为：

```text
企业最终批准的唯一实现
目标项目已经编译验证
目标项目已经 Runtime Verified
```

`guide-derived`、`legacy-project-derived`、`xworks-guide-derived` 描述 Reference 的来源，不自动提升其 Runtime Verification 状态。

## XWorks

只有 Project Context 明确：

```text
XWorks Enabled: true
```

时，才允许选择 `xworks: true` 的 Reference 作为当前项目实现依据。

如果：

```text
XWorks Enabled: false
```

或无法确认 XWorks 已启用，则不得把 `xworks: true` Reference 作为当前项目实现方案。

被排除技术栈中的 Reference 最多只能用于理解通用设计思想，不得据此推导当前技术栈存在等价：

- Class；
- Method；
- Status；
- Hook；
- Framework Behavior。

跨 Framework 的语义相似不能作为 API 或产品行为等价的证据。

## User-visible Behavior

Golden Reference 的检索和选择默认属于 Agent 内部工作过程。

常规任务中，不要逐步向用户播报：

```text
我先加载 Golden Reference Skill
我先读取 CATALOG
我选择 GR-XXX
我现在读取 reference.md
```

应优先直接回答用户真正的开发问题。

仅在以下情况有必要显式说明具体 Reference 或证据来源：

- 用户要求解释依据；
- Code Review 需要可追溯证据；
- 多个实现模式存在重要取舍；
- Reference 的 Candidate / Version / XWorks 状态会影响结论；
- 某项关键事实仍为 UNVERIFIED；
- 用户正在调试 DevKit / Golden Reference 本身。

即使需要说明来源，也应简洁说明，不需要输出内部检索流水。

Agent 可以在内部使用 Reference ID；普通用户不需要知道 Reference ID 才能获得 Golden Reference 能力。