Below is a **practical and easy-to-follow** breakdown of GitHub push (and general Git) practices, focusing on **naming conventions** for branches, commit messages, and pull requests. These guidelines will help keep your repository organized, understandable, and maintainable.

---

## 1. **Branch Naming Conventions**

Consistent branch naming makes it easier for everyone on the team to see at a glance the purpose of each branch. Here’s a straightforward scheme:

1. **Features**:  
   - **Prefix**: `feature/`  
   - **Example**: `feature/user-login`, `feature/cart-discounts`  
   - **Purpose**: For new features or significant functionality changes.

2. **Bugs**:  
   - **Prefix**: `bugfix/` (or `fix/`)  
   - **Example**: `bugfix/missing-avatar`, `bugfix/cart-total-error`  
   - **Purpose**: For fixing bugs or addressing specific issues.

3. **Hotfix** (Critical Production Bugs):  
   - **Prefix**: `hotfix/`  
   - **Example**: `hotfix/payment-crash`  
   - **Purpose**: For urgent fixes that need immediate attention on production.

4. **Refactor**:  
   - **Prefix**: `refactor/`  
   - **Example**: `refactor/cleanup-auth-service`  
   - **Purpose**: For improving or restructuring existing code without changing functionality.

5. **Experimental or Spike**:  
   - **Prefix**: `spike/` or `experiment/`  
   - **Example**: `spike/graphql-proof-of-concept`  
   - **Purpose**: For research or prototyping tasks.

**Style Note**: Use **kebab-case** (all lowercase, words separated by hyphens) inside your branch names, which is more legible and widely used. For example: `feature/payment-methods`.  

---

## 2. **Commit Message Conventions**

Clear commit messages help other developers (and your future self) quickly understand what each commit does.

### A. **Basic Format**

```
<type>(optional scope): <short summary>

[optional body]

[optional footer(s)]
```

**Types** could be `feat`, `fix`, `refactor`, `docs`, `test`, `chore`, etc. This is based on [Conventional Commits](https://www.conventionalcommits.org/). The body can explain the “why” of the change; the summary is the “what.”

### B. **Examples**

1. **Feature Commit**  
   ```
   feat: add user login endpoint

   - Implemented /login route
   - Added token-based authentication
   ```
2. **Fix Commit**  
   ```
   fix: correct rounding error in cart total

   - Changed rounding logic in CartService
   - Updated unit tests for new formula
   ```
3. **Refactor Commit**  
   ```
   refactor(auth): remove redundant checks

   - Simplify null check in AuthMiddleware
   - Code remains backward-compatible
   ```
4. **Docs Commit**  
   ```
   docs: add README instructions for deployment
   ```
5. **Chore or Config Commit**  
   ```
   chore: update .gitignore for logs
   ```

### C. **Why These Formats?**
- **Readability**: Other contributors immediately see the intention of each commit.  
- **Tooling**: Many CI/CD tools can parse conventional commits for automated changelogs, versioning, etc.  
- **History**: Searching for specific types of commits is easier (e.g., `feat`, `fix`).

---

## 3. **Pull Request Titles and Descriptions**

When you open a **Pull Request** on GitHub, follow a similar style so reviewers understand the change instantly. Keep your PR titles concise, but descriptive.

1. **PR Title**:  
   - If using Conventional Commits style, you can reuse it:  
     - `feat: add user login endpoint`  
     - `fix: correct rounding error in cart total`
   - Or a simple sentence like:  
     - `Add user login endpoint and authentication flow`

2. **Description**:
   - **Summary** of changes: bullet points or short paragraph.  
   - **Motivation** or reason for change.  
   - **Related Issues**: Link to GitHub Issues or JIRA tickets.  
   - **Testing**: Outline how you tested your changes.  
   - **Screenshots** (if relevant): For UI changes, include screenshots or GIFs.

---

## 4. **Push Practices**

- **Frequent, Small Commits**: Push small, logical commits rather than giant ones. This makes review easier.  
- **Descriptive Commit Summaries**: Summaries like “updates” or “misc changes” are too vague.  
- **Rebase or Merge**:  
  - **Rebase** keeps a linear history (commonly used in smaller teams).  
  - **Merge** preserves the true timeline (common in large or open-source projects).

---

## 5. **Example Workflow**

1. **Create a Branch**  
   - `git checkout -b feature/add-user-login`  
2. **Make Changes**  
   - Write code, commit regularly following the format:  
     ```
     feat: add initial login service

     - Created AuthService.java
     - Implemented login method
     ```
3. **Push the Branch**  
   - `git push origin feature/add-user-login`  
4. **Open a Pull Request**  
   - **Title**: `feat: add user login endpoint`  
   - **Description**: Summarize your changes, link any issues, provide test details.  
5. **Review & Merge**  
   - Colleagues review code.  
   - Once approved, use **Squash and Merge** or **Merge** based on your team’s policy.  

---

## 6. **Tips & Best Practices**

1. **Link Issues or Tickets** in Commit Messages:  
   - e.g., `fix: correct rounding error (#123)`, linking to an issue or PR.  
2. **Use GitHub Keywords** in Commits/PRs:  
   - e.g., `fixes #123` automatically closes Issue #123 upon merge.  
3. **Branch Cleanup**:  
   - After merging, delete the branch unless you have a reason to keep it.
4. **Automate Checking**:  
   - Tools like **Git hooks**, **CI pipelines**, or **lint-staged** can ensure commit messages follow the correct format.  
5. **Code Reviews**:  
   - Keep PRs small and focused, making review faster and more effective.

---

### **Summary**

- **Branch Naming**: Use short prefixes like `feature/`, `bugfix/`, `hotfix/`, `refactor/`, etc., and keep descriptive names in **kebab-case**.  
- **Commit Messages**: Use a consistent style, ideally [Conventional Commits](https://www.conventionalcommits.org/) with a `type(scope): message` format.  
- **Pull Requests**: Concise titles, clear descriptions, reference issues, and attach screenshots or tests if needed.  
- **Push Often**: Commit small, cohesive changes and push them regularly for easier collaboration and reviewing.

Following these guidelines will keep your repository clean, consistent, and easy for all contributors (current and future) to understand.