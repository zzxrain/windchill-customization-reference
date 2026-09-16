---
name: windchill-golden-reference
description: 当任务涉及 Windchill 专有实现模式、设计、代码生成、Code Review 或 Debug 时使用，例如 QuerySpec、DataUtility、Validator、FormProcessor、Listener、StandardManager、Service、Queue、JCA/MVC、Workflow、Configuration 等。对这类任务，Agent 应先扫描 CATALOG.md 判断是否存在直接匹配的企业批准/候选实现模式，用户无需显式提及 Golden Reference。只读取最小充分的 1～3 个 Reference，不要全量加载。
---

# Windchill Golden Reference Skill

## When to use

本 Skill 回答：

> 同类 Windchill 定制通常怎么实现？

典型场景包括：

- 新增 Windchill 二次开发实现；
- 修改已有 Windchill 定制；
- 给出 Windchill-specific 技术设计；
- 生成或修改 Windchill Java 代码；
- Code Review；
- Debug / Troubleshooting 中需要判断正确实现模式；
- 当前项目存在多种历史写法，需要选择更合适的模式。

典型技术主题包括但不限于：

```text
QuerySpec
Persistence
Transaction
Version / Iteration
DataUtility
Validator
FormProcessor
Action / ActionModel
JCA / MVC
Listener
StandardManager
Service
Queue
Workflow
Configuration
XCONF
XWorks
```

用户无需在 Prompt 中显式要求：

```text
Golden Reference
Golden Code
PTC Guide Example
Reference Pattern
```

Agent 应根据任务本身自主判断是否需要本 Skill。

如果当前任务只是：

- 普通文本修改；
- 与 Windchill 无关的 Java 重构；
- 明确的纯算法修改；
- 不依赖任何 Windchill 专有实现模式的局部变更；

则不应为了展示能力而调用本 Skill。

---

## Mandatory Catalog Preflight

当用户要求以下任一行为，并且任务涉及 Windchill 专有机制时：

```text
怎么实现
怎么设计
给代码
修改代码
Code Review
重构 Windchill 定制
排查 Windchill-specific 实现问题
```

Agent 在最终回答前必须先进行一次 Golden Catalog Preflight：

```text
Read CATALOG.md
        ↓
Check direct scenario match
        ↓
No strong match?
        └── Stop Golden lookup

Strong match?
        ↓
Select minimum sufficient Reference
        ↓
Read reference.md
        ↓
Reference Sufficiency Gate
        ↓
Need implementation detail from source?
        ├── No  → Stop Golden lookup
        └── Yes → Read minimum necessary src/*
```

Catalog Preflight 不等于加载全部 Golden Repository。

它的目的只是回答：

```text
当前任务是否已经存在直接匹配的企业实现模式？
```

不得因为已经从 QMind / PTC Guide 得到了官方产品知识，就跳过实现模式检查。

同样，不得因为找到了 Golden Reference，就跳过产品事实或 API Metadata 的独立验证。

---

## Selection Preference

Reference 选择顺序：

1. 当前任务 Scenario 是否直接匹配；
2. Project `AGENTS.md`、架构和技术栈约束是否允许；
3. Reference Status 和目标版本适用性；
4. Source Provenance。

Source Provenance 主要用于同等匹配候选之间的判断：

- `PTC Guide`：优先用于理解官方扩展机制、生命周期和推荐集成点；
- `Legacy Project`：用于补充真实项目中的工程化实现、兼容方式和常见上下文；
- `XWorks Guide`：仅在 Project Context 明确允许 XWorks 时用于 XWorks 实现模式。

不得因为 Reference 来自 `PTC Guide`，就选择场景匹配较弱的通用条目替代直接匹配条目。

---

## Minimum Sufficient Selection

Golden Reference 不是“越多越好”。

选择规则：

```text
1 个直接匹配 Reference 已经覆盖问题
→ 只使用 1 个

第二个 Reference 提供独立且不可替代的信息
→ 可以增加

只是重复第一条的通用模式
→ 不增加
```

默认：

```text
1～3 个 Reference
```

是上限，不是目标数量。

例如：

```text
Wizard Post-Submit Validation
→ GR-VALIDATOR-003 已完整覆盖
→ 不应为了数量再添加 Post-Select Reference
```

而：

```text
DataUtility instance cache
→ 一个 Reference 描述 setModelData / prefetch
→ 另一个 Reference 独立描述 registration / cardinality
→ 可以同时使用
```

---

## Quality-First Evidence Budget

性能优化不得降低答案所需的 Evidence Coverage。

核心原则：

```text
先使用最便宜且足够的 Evidence，
但只要仍存在影响正确性的 Evidence Gap，
就必须继续取证。
```

Golden 的优化对象是：

```text
不必要的读取深度
重复 Reference
无目的目录探测
机会主义式的额外查阅
```

不是：

```text
必要的产品事实
必要的 API 验证
必要的实现模式
```

### Pattern-level Task

如果用户主要要求：

```text
怎么设计
采用什么模式
职责怎么拆
大致应该怎么实现
这种方式是否合适
```

并且所选 `reference.md` 已经直接覆盖所需 Implementation Pattern：

```text
CATALOG.md
→ 1 个直接匹配 reference.md
→ Pattern Evidence Sufficient
→ Stop Golden lookup
```

默认不得继续读取：

```text
src/*
```

只是因为：

```text
目录里还有示例代码
可能还能找到更多细节
顺便确认一下实现
```

都不足以构成读取 Source 的理由。

### Implementation-level Task

以下场景可以继续读取最小必要的 `src/*`：

```text
用户明确要求具体代码
用户要求修改现有实现
Code Review 需要与完整实现对照
Debug 需要定位调用结构
reference.md 没有提供解决问题所需的实现细节
需要确认 Golden 自身实际采用的工程组织方式
```

即使需要 Source，也只读取：

```text
当前结论真正依赖的文件
```

不得因为进入一个 Reference，就默认遍历其全部 Source。

### Diagnostic-level Task

对于：

```text
Debug
Code Review
历史实现比较
```

如果问题本身依赖具体控制流、异常处理、生命周期或调用链，可以读取对应 Source。

但读取必须回答一个明确问题，例如：

```text
这个 Listener 在哪里注册？
这个 DataUtility 在哪里做批量预取？
这个 Validator 在哪个 phase 返回状态？
```

不得进行：

```text
看看还有什么
把整个目录都读一遍
```

式探索。

---

## Reference Sufficiency Gate

读取 `reference.md` 后，在继续 Golden Tool Call 前先判断：

```text
当前用户要求的答案层级是什么？
当前 Reference 是否已经覆盖该层级所需 Pattern？
```

### 可以停止 Golden Lookup

如果同时满足：

```text
Reference Scenario 直接匹配
+
Review Notes / Agent Guidance 已覆盖所需 Pattern
+
最终答案不依赖 Reference Source 中额外实现细节
```

则停止读取 Golden。

### 必须继续

如果：

```text
用户要求具体实现，而 reference.md 信息不足
或
当前结论依赖 Source 中的结构
或
Reference 自身存在歧义
```

则读取最小必要 Source。

### Golden 停止不等于 Evidence 停止

即使 Golden 已经充分，也仍必须检查：

```text
Product / Framework Fact Gap
Exact API Metadata Gap
Compile Gap
Runtime Gap
```

这些按照 Evidence Handoff 继续处理。

因此：

```text
Stop Golden lookup
```

绝不意味着：

```text
Stop all verification
```

---

## Tool Call Discipline

每增加一次 Golden Tool Call，都应对应一个明确尚未解决的问题。

允许：

```text
读取直接匹配的 reference.md
读取为回答具体实现问题所必需的一个或少量 src 文件
```

避免：

```text
为了“保险”重复读取同一个 reference.md
在已经知道 Reference Path 后重新搜索整个 Golden Repository
递归列出整个 Golden Repository
没有具体问题时执行 ls -R / find
读取与当前答案无直接关系的相邻 Reference
```

如果确实需要知道某个 Selected Reference 的 Source 文件：

```text
只枚举该 Reference 自身目录
```

不得从 Golden Root 开始递归扫描。

---

## Stop Condition

当以下条件同时满足时：

```text
用户所需 Implementation Pattern 已经得到支持
+
不存在需要从 Golden Source 补充的具体实现细节
```

应立即结束 Golden Lookup。

不得因为以下理由继续：

```text
worth checking
might also help
for completeness
perhaps another example
```

如果仍存在：

```text
Framework / Product Behavior Gap
Exact API Gap
```

应交给对应 Evidence Source，而不是继续扩大 Golden 搜索。

---

## Reference ID

Reference ID：

```text
GR-<MODULE>-<NNN>
```

ID 是稳定标识，不因 Catalog 排序或新增重新编号。

---

## Workflow

1. 读取当前 Project `AGENTS.md`（如存在）。
2. 从 Project Context、用户输入或项目资料确认已知的 Windchill Version 和 `XWorks Enabled`。
3. 无法确认时不得自行猜测。
4. 对 Windchill-specific implementation / design / review / debug 执行 Catalog Preflight。
5. 先按模块定位，再按 Scenario / Project Constraint / Status / Source / XWorks 筛选候选。
6. 只选择最小充分 Reference。
7. 读取最终选择的 `reference.md`。
8. 执行 Reference Sufficiency Gate。
9. Pattern-level 已充分时停止 Golden Lookup，不默认读取 `src/*`。
10. 只有具体实现、Review 或 Debug 确实依赖 Source 时，才读取最小必要的 `src/*`。
11. 将 Reference 作为实现模式，不机械复制示例业务。
12. 对 Reference 没有证明的事实继续执行 Evidence Handoff。
13. 如 Reference 与 Rules / Project ADR / Approved Exception 冲突，服从更高优先级约束。

---

## Evidence Handoff

Golden Reference 主要证明：

```text
Implementation Pattern
```

它不能自动证明：

```text
Exact API Metadata
Framework Behavior
Compile Verification
Runtime Verification
```

因此在应用 Reference 后，Agent 必须检查是否仍存在以下证据缺口。

### Framework / Product Behavior

例如：

```text
Event veto semantics
Validation phase behavior
DataUtility lifecycle
Wizard client behavior
Queue semantics
Transaction behavior
```

需要：

```text
目标版本 PTC 官方资料
/
QMind
```

不得仅根据 Reference 中的代码形态推导产品行为。

### Exact API / Type Metadata

例如：

```text
Class 是否存在
Method 是否存在
Signature
Return Type
Throws
Constant
Supported
Extendable
Deprecated
Class hierarchy
Implemented interfaces
Versioned / Iterated / Workable 等类型能力
```

需要：

```text
目标版本 Javadoc
/
windchill-api-lookup
```

如果目标版本和 API Lookup 已可用，应实际执行验证。

不得只在回答结尾写：

> 建议再对照 Javadoc 确认。

然后把未经验证的精确 API 当作已确认代码输出。

API Lookup 不可用时，可以继续提供 Pattern-level 方案，但相关精确 API 必须标记为：

```text
UNVERIFIED PTC API
```

### Compile

只有真实 Target Classpath Build 才能证明：

```text
Compile Verified
```

### Runtime

只有实际 Windchill Runtime 才能证明：

```text
Runtime Verified
```

---

## Candidate Policy

当前 Corpus 中的 Reference 主要为：

```text
candidate
```

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

`guide-derived`、`legacy-project-derived`、`xworks-guide-derived` 描述 Reference 来源，不自动提升其验证级别。

---

## XWorks

只有 Project Context 明确：

```text
XWorks Enabled: true
```

时，才允许选择：

```text
xworks: true
```

的 Reference 作为当前项目实现依据。

如果：

```text
XWorks Enabled: false
```

或无法确认 XWorks 已启用，则不得把 `xworks: true` Reference 作为当前实现方案。

被排除技术栈中的 Reference 最多用于理解通用设计思想，不得据此推导当前技术栈存在等价：

- Class；
- Method；
- Status；
- Hook；
- Framework Behavior。

跨 Framework 的语义相似不能作为 API 或产品行为等价的证据。

---

## Silent Invocation

Golden 的检索、Catalog Preflight 和 Reference 读取属于内部工作过程。

**调用本 Skill、读取 Catalog 或 Reference 前，不得先发送用户可见的进度说明。**

禁止输出：

```text
我先查一下 Golden Reference
我先读取 CATALOG
我找到 GR-XXX，接下来读取它
我先看看企业参考代码
```

正确行为：

```text
内部直接调用 / 读取
        ↓
完成必要证据收集
        ↓
第一个用户可见文本直接回答实际问题
```

只有以下情况可以在最终答案中简要说明具体 Reference：

- 用户明确要求依据；
- Code Review 要求可追溯性；
- Candidate / Approved 状态本身影响结论；
- 多个模式存在重要取舍；
- 某项事实仍然 `UNVERIFIED`；
- 用户正在调试 Golden / DevKit 本身。

即使需要说明，也只说明最终依据，不输出内部检索流水。