document.addEventListener('DOMContentLoaded', () => {
    // State
    let currentUser = null;
    let tasks = [];
    let users = [];

    // DOM Elements
    const loginContainer = document.getElementById('login-container');
    const registerContainer = document.getElementById('register-container');
    const dashboardContainer = document.getElementById('dashboard-container');

    // Login Form
    const loginForm = document.getElementById('login-form');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const loginError = document.getElementById('login-error');
    const gotoRegister = document.getElementById('goto-register');

    // Register Form
    const registerForm = document.getElementById('register-form');
    const regName = document.getElementById('reg-name');
    const regUser = document.getElementById('reg-user');
    const regPass = document.getElementById('reg-pass');
    const gotoLogin = document.getElementById('goto-login');

    // Dashboard
    const welcomeMsg = document.getElementById('welcome-msg');
    const logoutBtn = document.getElementById('logout-btn');
    const newTaskInput = document.getElementById('new-task');
    const addTaskBtn = document.getElementById('add-task-btn');
    const taskList = document.getElementById('task-list');
    const emptyState = document.getElementById('empty-state');
    const userAvatarMini = document.querySelector('.user-avatar-mini');

    // Hardcoded credentials for Demo - REMOVED, now using DB

    // Init Database (LocalStorage)
    function initDB() {
        const storedUsers = localStorage.getItem('users');
        if (storedUsers) {
            users = JSON.parse(storedUsers);
        } else {
            // Seed Admin
            users = [{ name: 'Administrador', user: 'admin', pass: 'admin123', bio: '', skills: [] }];
            localStorage.setItem('users', JSON.stringify(users));
        }

        initTasks(); // Load persistent tasks

        // Check active session
        const sessionUser = localStorage.getItem('sessionUser');
        if (sessionUser) {
            currentUser = JSON.parse(sessionUser);
            loadDashboard();
        }
    }

    // Helpers
    function show(element) {
        element.classList.remove('hidden');
        element.classList.add('visible');
    }

    function hide(element) {
        element.classList.add('hidden');
        element.classList.remove('visible');
    }

    // Auth Logic
    function loadDashboard() {
        welcomeMsg.textContent = `Olá, ${currentUser.name.split(' ')[0]}`;
        // Update avatar
        const avatarUrl = `https://ui-avatars.com/api/?name=${currentUser.name}&background=random`;
        userAvatarMini.style.backgroundImage = `url('${avatarUrl}')`;
        document.getElementById('avatar-preview').style.backgroundImage = `url('${avatarUrl}')`;

        hide(loginContainer);
        hide(registerContainer);
        show(dashboardContainer);
        renderTasks();
        loadProfileData(); // Pre-fill profile
    }

    function saveTasks() {
        localStorage.setItem('tasks', JSON.stringify(tasks));
        renderTasks();
    }

    function initTasks() {
        const stored = localStorage.getItem('tasks');
        if (stored) {
            tasks = JSON.parse(stored);
        } else {
            tasks = [
                { text: 'Aprender Cypress', completed: false },
                { text: 'Criar Page Objects', completed: false }
            ];
            saveTasks();
        }
    }

    function renderTasks() {
        taskList.innerHTML = '';

        if (tasks.length === 0) {
            show(emptyState);
        } else {
            hide(emptyState);
            tasks.forEach((task, index) => {
                const li = document.createElement('li');
                li.className = 'task-item';
                li.innerHTML = `
                    <div class="task-content">
                        <button class="check-btn ${task.completed ? 'completed' : ''}" onclick="toggleTask(${index})">
                            ${task.completed ? '✓' : ''}
                        </button>
                        <span class="task-text ${task.completed ? 'completed' : ''}">${task.text}</span>
                    </div>
                    <div class="task-actions">
                        <button class="action-btn small" onclick="editTask(${index})" title="Editar">✎</button>
                        <button class="action-btn small delete" onclick="deleteTask(${index})" title="Excluir">×</button>
                    </div>
                `;
                taskList.appendChild(li);
            });
        }
    }

    window.toggleTask = function (index) {
        tasks[index].completed = !tasks[index].completed;
        saveTasks();
    };

    window.deleteTask = function (index) {
        customConfirm('Deseja excluir esta tarefa?', () => {
            tasks.splice(index, 1);
            saveTasks();
            showToaster('Tarefa excluída.');
        });
    };

    window.editTask = function (index) {
        const newText = prompt('Editar tarefa:', tasks[index].text);
        if (newText !== null && newText.trim() !== "") {
            tasks[index].text = newText.trim();
            saveTasks();
            showToaster('Tarefa atualizada.');
        }
    };

    // Events
    loginForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const user = usernameInput.value;
        const pass = passwordInput.value;

        const foundUser = users.find(u => u.user === user && u.pass === pass);

        if (foundUser) {
            currentUser = foundUser;
            localStorage.setItem('sessionUser', JSON.stringify(currentUser));
            hide(loginError);
            loadDashboard();
        } else {
            show(loginError);
            loginContainer.classList.add('shake');
            setTimeout(() => loginContainer.classList.remove('shake'), 500);
        }
    });

    registerForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const name = regName.value;
        const user = regUser.value;
        const pass = regPass.value;

        if (users.find(u => u.user === user)) {
            showToaster('Erro: Usuário já existe!');
            return;
        }

        const newUser = { name, user, pass, bio: '', skills: [] };
        users.push(newUser);
        localStorage.setItem('users', JSON.stringify(users));

        showToaster('Conta criada com sucesso! Faça login.');
        hide(registerContainer);
        show(loginContainer);
    });

    gotoRegister.addEventListener('click', (e) => {
        e.preventDefault();
        hide(loginContainer);
        show(registerContainer);
    });

    gotoLogin.addEventListener('click', (e) => {
        e.preventDefault();
        hide(registerContainer);
        show(loginContainer);
    });

    logoutBtn.addEventListener('click', () => {
        currentUser = null;
        localStorage.removeItem('sessionUser');
        usernameInput.value = '';
        passwordInput.value = '';
        hide(dashboardContainer);
        show(loginContainer);
    });

    addTaskBtn.addEventListener('click', () => {
        const text = newTaskInput.value.trim();
        if (text) {
            tasks.push({ text, completed: false });
            newTaskInput.value = '';
            saveTasks();
        }
    });

    // Profile Logic
    function loadProfileData() {
        if (!currentUser) return;
        document.getElementById('profile-name').value = currentUser.name;
        document.getElementById('profile-bio').value = currentUser.bio || '';
        document.getElementById('profile-phone').value = currentUser.phone || '';

        renderSkills();
    }

    function renderSkills() {
        const container = document.getElementById('skills-container');
        // Clear all except input
        const tags = container.querySelectorAll('.tag');
        tags.forEach(el => el.remove());

        const skills = currentUser.skills || [];
        skills.forEach(skill => {
            const span = document.createElement('span');
            span.className = 'tag';
            span.innerHTML = `${skill} <i class="remove-skill" data-skill="${skill}">×</i>`;
            container.insertBefore(span, document.getElementById('add-skill'));
        });

        // Re-attach delete listeners
        document.querySelectorAll('.remove-skill').forEach(btn => {
            btn.addEventListener('click', (e) => {
                const skillToRemove = e.target.getAttribute('data-skill');
                currentUser.skills = currentUser.skills.filter(s => s !== skillToRemove);
                updateUserInDB();
                renderSkills();
            });
        });
    }

    function updateUserInDB() {
        const index = users.findIndex(u => u.user === currentUser.user);
        if (index > -1) {
            users[index] = currentUser;
            localStorage.setItem('users', JSON.stringify(users));
            localStorage.setItem('sessionUser', JSON.stringify(currentUser));
        }
    }

    // Add Skill Input
    const addSkillInput = document.getElementById('add-skill');
    addSkillInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            e.preventDefault();
            const val = addSkillInput.value.trim();
            if (val) {
                if (!currentUser.skills) currentUser.skills = [];
                if (!currentUser.skills.includes(val)) {
                    currentUser.skills.push(val);
                    updateUserInDB();
                    renderSkills();
                }
                addSkillInput.value = '';
            }
        }
    });

    initDB();
    // Navigation Elements
    const views = {
        'dashboard': document.getElementById('view-dashboard'),
        'kanban': document.getElementById('view-kanban'),
        'team': document.getElementById('view-team'),
        'profile': document.getElementById('view-profile'),
        'settings': document.getElementById('view-settings')
    };

    const navLinks = {
        'dashboard': document.getElementById('nav-dashboard'),
        'kanban': document.getElementById('nav-kanban'),
        'team': document.getElementById('nav-team'),
        'profile': document.getElementById('nav-profile'),
        'settings': document.getElementById('nav-settings')
    };

    const toaster = document.getElementById('toaster');

    function switchView(viewName) {
        // Hide all views and remove active class from all links
        Object.keys(views).forEach(key => {
            hide(views[key]);
            if (navLinks[key]) navLinks[key].classList.remove('active');
        });

        // Show selected view and activate link
        if (views[viewName]) show(views[viewName]);
        if (navLinks[viewName]) navLinks[viewName].classList.add('active');

        // Load data specific to view
        if (viewName === 'team') loadTeamData();
    }

    // Attach Event Listeners to Nav Links
    Object.keys(navLinks).forEach(key => {
        if (navLinks[key]) {
            navLinks[key].addEventListener('click', (e) => {
                e.preventDefault();
                switchView(key);
            });
        }
    });

    // --- Mock Data Logic for New Pages ---

    // Team Data Logic
    let teamData = [];

    // Elements for Team Edit
    const teamModalOverlay = document.getElementById('team-modal-overlay');
    const teamEditId = document.getElementById('team-edit-id');
    const teamEditName = document.getElementById('team-edit-name');
    const teamEditRole = document.getElementById('team-edit-role');
    const teamEditLevel = document.getElementById('team-edit-level');
    const teamSaveBtn = document.getElementById('team-save-btn');
    const teamCancelBtn = document.getElementById('team-cancel-btn');
    const searchInput = document.getElementById('search-member');

    function initTeamData() {
        const stored = localStorage.getItem('teamData');
        if (stored) {
            teamData = JSON.parse(stored);
        } else {
            teamData = [
                { id: 1, name: "Ana Silva", role: "QA Lead", status: "Active", level: "Senior" },
                { id: 2, name: "Carlos Rocha", role: "Frontend Dev", status: "Active", level: "Mid" },
                { id: 3, name: "Beatriz Costa", role: "Product Owner", status: "Out", level: "Senior" },
                { id: 4, name: "João Oliveira", role: "Backend Dev", status: "Active", level: "Junior" }
            ];
            saveTeamData();
        }
    }

    function saveTeamData() {
        localStorage.setItem('teamData', JSON.stringify(teamData));
        renderTeamTable();
    }

    function renderTeamTable(filterText = '') {
        const tbody = document.getElementById('team-tbody');
        tbody.innerHTML = '';

        const filtered = teamData.filter(m =>
            m.name.toLowerCase().includes(filterText.toLowerCase()) ||
            m.role.toLowerCase().includes(filterText.toLowerCase())
        );

        filtered.forEach(m => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${m.name}</td>
                <td>${m.role}</td>
                <td><span class="badge ${m.status === 'Active' ? 'badge-success' : 'badge-secondary'}">${m.status}</span></td>
                <td><span class="badge badge-primary">${m.level}</span></td>
                <td>
                    <button class="action-btn edit-btn" data-id="${m.id}" title="Editar">✎</button>
                    <button class="action-btn delete-btn-team" data-id="${m.id}" title="Remover">🗑</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        // Re-attach listeners since we just wiped DOM
        attachTeamListeners();
    }

    const confirmModalOverlay = document.getElementById('confirm-modal-overlay');
    const confirmOkBtn = document.getElementById('confirm-ok-btn');
    const confirmCancelBtn = document.getElementById('confirm-cancel-btn');
    const confirmMsg = document.getElementById('confirm-modal-msg');

    function customConfirm(msg, onConfirm) {
        confirmMsg.innerText = msg;
        show(confirmModalOverlay);

        const handleConfirm = () => {
            onConfirm();
            closeConfirm();
        };

        const closeConfirm = () => {
            hide(confirmModalOverlay);
            confirmOkBtn.removeEventListener('click', handleConfirm);
            confirmCancelBtn.removeEventListener('click', closeConfirm);
        };

        confirmOkBtn.addEventListener('click', handleConfirm);
        confirmCancelBtn.addEventListener('click', closeConfirm);
    }

    function attachTeamListeners() {
        // Edit 
        document.querySelectorAll('.edit-btn').forEach(btn => {
            btn.addEventListener('click', (e) => {
                const id = e.target.getAttribute('data-id');
                openTeamModal(id);
            });
        });

        // Delete
        document.querySelectorAll('.delete-btn-team').forEach(btn => {
            btn.addEventListener('click', (e) => {
                const id = e.target.getAttribute('data-id');
                customConfirm('Tem certeza que deseja remover este membro?', () => {
                    teamData = teamData.filter(m => m.id != id);
                    saveTeamData();
                    showToaster('Membro removido.');
                });
            });
        });
    }

    function openTeamModal(id = null) {
        if (id) {
            const member = teamData.find(m => m.id == id);
            if (!member) return;

            teamEditId.value = member.id;
            teamEditName.value = member.name;
            teamEditRole.value = member.role;
            teamEditLevel.value = member.level;
            document.querySelector('#team-modal-overlay h3').innerText = 'Editar Membro';
        } else {
            teamEditId.value = '';
            teamEditName.value = '';
            teamEditRole.value = '';
            teamEditLevel.value = 'Junior';
            document.querySelector('#team-modal-overlay h3').innerText = 'Novo Membro';
        }

        show(teamModalOverlay);
    }

    function closeTeamModal() {
        hide(teamModalOverlay);
    }

    // Modal Actions
    if (teamSaveBtn) {
        const newSaveBtn = teamSaveBtn.cloneNode(true);
        teamSaveBtn.parentNode.replaceChild(newSaveBtn, teamSaveBtn);
        newSaveBtn.addEventListener('click', () => {
            const id = teamEditId.value;
            const name = teamEditName.value.trim();
            const role = teamEditRole.value.trim();
            const level = teamEditLevel.value;

            if (!name || !role) {
                showToaster('Por favor, preencha nome e cargo.');
                return;
            }

            if (id) {
                // Edit
                const memberIndex = teamData.findIndex(m => m.id == id);
                if (memberIndex > -1) {
                    teamData[memberIndex].name = name;
                    teamData[memberIndex].role = role;
                    teamData[memberIndex].level = level;
                    saveTeamData();
                    showToaster('Membro atualizado!');
                }
            } else {
                // Add
                const newId = teamData.length > 0 ? Math.max(...teamData.map(m => m.id)) + 1 : 1;
                teamData.push({
                    id: newId,
                    name: name,
                    role: role,
                    status: 'Active',
                    level: level
                });
                saveTeamData();
                showToaster('Membro adicionado!');
            }
            closeTeamModal();
        });
    }

    const addMemberBtn = document.getElementById('add-member-btn');
    if (addMemberBtn) {
        addMemberBtn.addEventListener('click', () => openTeamModal());
    }

    if (teamCancelBtn) {
        const newCancel = teamCancelBtn.cloneNode(true);
        teamCancelBtn.parentNode.replaceChild(newCancel, teamCancelBtn);
        newCancel.addEventListener('click', closeTeamModal);
    }

    // Search
    if (searchInput) {
        searchInput.addEventListener('input', (e) => {
            renderTeamTable(e.target.value);
        });
    }

    function loadTeamData() {
        // Called by switchView
        initTeamData();
        renderTeamTable();
        // Initial render handles populated check implicitly by overwriting or staying empty 
        // if we want to preserve state we just re-render from state
    }

    // Profile Save
    const profileForm = document.getElementById('profile-form');
    if (profileForm) {
        profileForm.addEventListener('submit', (e) => {
            e.preventDefault();
            if (!currentUser) return;

            currentUser.name = document.getElementById('profile-name').value;
            currentUser.phone = document.getElementById('profile-phone').value;
            currentUser.bio = document.getElementById('profile-bio').value;

            updateUserInDB();

            // Refresh dashboard view for name changes
            welcomeMsg.textContent = `Olá, ${currentUser.name.split(' ')[0]}`;
            const avatarUrl = `https://ui-avatars.com/api/?name=${currentUser.name}&background=random`;
            userAvatarMini.style.backgroundImage = `url('${avatarUrl}')`;

            showToaster("Perfil atualizado com sucesso!");
        });
    }

    // Kanban Logic (Drag & Drop + LocalStorage Persistence)
    const columns = document.querySelectorAll('.kanban-column');
    let draggedCard = null;

    function initKanban() {
        // Load from LocalStorage or Default
        const storedData = localStorage.getItem('kanbanData');
        let cardData = [];

        if (storedData) {
            cardData = JSON.parse(storedData);
        } else {
            // Default Seed Data
            cardData = [
                { id: 1, title: "Criar Testes E2E", col: "col-todo" },
                { id: 2, title: "Refatorar CSS", col: "col-doing" },
                { id: 3, title: "Configurar CI/CD", col: "col-done" }
            ];
            saveKanban(cardData);
        }

        renderKanban(cardData);
        setupDragAndDrop();
        setupAddCard();
    }

    function saveKanban(data) {
        localStorage.setItem('kanbanData', JSON.stringify(data));
        updateCounts();
    }

    function getKanbanState() {
        const cards = [];
        document.querySelectorAll('.kanban-card').forEach(card => {
            cards.push({
                id: card.dataset.id,
                title: card.innerText.replace('×', '').trim(), // Remove the 'x' from delete button
                col: card.parentElement.parentElement.id
            });
        });
        return cards;
    }

    function renderKanban(data) {
        // Clear columns
        document.querySelectorAll('.col-body').forEach(col => col.innerHTML = '');

        data.forEach(card => {
            createCardElement(card.title, card.col, card.id);
        });
        updateCounts();
    }

    function createCardElement(title, colId, id = Date.now()) {
        const cardAcc = document.createElement('div');
        cardAcc.className = 'kanban-card';
        cardAcc.innerText = title;
        cardAcc.draggable = true;
        cardAcc.dataset.id = id;

        // Delete button for card
        const delBtn = document.createElement('span');
        delBtn.innerHTML = '×';
        delBtn.className = 'delete-card-btn';
        delBtn.onclick = (e) => {
            e.stopPropagation(); // Prevent drag start
            cardAcc.remove();
            saveKanban(getKanbanState());
        };
        cardAcc.appendChild(delBtn);

        document.querySelector(`#${colId} .col-body`).appendChild(cardAcc);
        return cardAcc;
    }

    function setupDragAndDrop() {
        document.addEventListener('dragstart', (e) => {
            if (e.target.classList.contains('kanban-card')) {
                draggedCard = e.target;
                e.target.style.opacity = '0.5';
            }
        });

        document.addEventListener('dragend', (e) => {
            if (e.target.classList.contains('kanban-card')) {
                e.target.style.opacity = '1';
                draggedCard = null;
                saveKanban(getKanbanState());
            }
        });

        columns.forEach(col => {
            col.addEventListener('dragover', (e) => {
                e.preventDefault();
                col.classList.add('drag-over');
            });

            col.addEventListener('dragleave', () => {
                col.classList.remove('drag-over');
            });

            col.addEventListener('drop', (e) => {
                e.preventDefault();
                col.classList.remove('drag-over');
                const colBody = col.querySelector('.col-body');
                if (draggedCard) {
                    colBody.appendChild(draggedCard);
                    updateCounts();
                    saveKanban(getKanbanState()); // Save state after drop
                }
            });
        });
    }

    function setupAddCard() {
        const addBtn = document.getElementById('add-project-btn');
        const modalOverlay = document.getElementById('modal-overlay');
        const confirmBtn = document.getElementById('confirm-modal-btn');
        const cancelBtn = document.getElementById('cancel-modal-btn');
        const titleInput = document.getElementById('modal-task-title');

        // Clean up old listeners if any by cloning (simplest way without named functions)
        const newAddBtn = addBtn.cloneNode(true);
        addBtn.parentNode.replaceChild(newAddBtn, addBtn);

        // Open Modal
        newAddBtn.addEventListener('click', () => {
            titleInput.value = '';
            show(modalOverlay);
            titleInput.focus();
        });

        // Close Modal
        const closeModal = () => {
            hide(modalOverlay);
        };

        const createFromModal = () => {
            const title = titleInput.value.trim();
            if (title) {
                createCardElement(title, 'col-todo');
                saveKanban(getKanbanState());
                showToaster("Card adicionado com sucesso!");
                closeModal();
            }
        };

        // listeners with removing old ones to prevent stacking if init called multiple times 
        // (Though in this architecture init is called once, but good practice for SPA-like re-renders)
        const newConfirmBtn = confirmBtn.cloneNode(true);
        confirmBtn.parentNode.replaceChild(newConfirmBtn, confirmBtn);
        newConfirmBtn.addEventListener('click', createFromModal);

        const newCancelBtn = cancelBtn.cloneNode(true);
        cancelBtn.parentNode.replaceChild(newCancelBtn, cancelBtn);
        newCancelBtn.addEventListener('click', closeModal);

        // Enter key in modal input
        const newTitleInput = titleInput.cloneNode(true);
        titleInput.parentNode.replaceChild(newTitleInput, titleInput);
        newTitleInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') createFromModal();
        });
    }

    function updateCounts() {
        ['todo', 'doing', 'done'].forEach(col => {
            const count = document.querySelector(`#col-${col} .col-body`).children.length;
            document.querySelector(`#col-${col} .count`).innerText = count;
        });
    }

    // Initialize Kanban once
    initKanban();

    function showToaster(msg) {
        toaster.innerText = msg;
        show(toaster);
        setTimeout(() => hide(toaster), 3000);
    }

    // Settings
    const settingsForm = document.getElementById('settings-form');
    const themeSelect = document.getElementById('theme-select');

    function initSettings() {
        const savedTheme = localStorage.getItem('theme') || 'dark';
        if (themeSelect) themeSelect.value = savedTheme;
        applyTheme(savedTheme);
    }

    function applyTheme(theme) {
        if (theme === 'light') {
            document.body.classList.add('light-mode');
        } else {
            document.body.classList.remove('light-mode');
        }
    }

    if (settingsForm) {
        settingsForm.addEventListener('submit', (e) => {
            e.preventDefault();
            const theme = themeSelect.value;
            localStorage.setItem('theme', theme);
            applyTheme(theme);
            showToaster("Configurações salvas com sucesso!");
        });
    }

    initSettings();
});
