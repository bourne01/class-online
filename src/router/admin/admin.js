export default [    
    {
        path:'/admin',        
        component:() => import('../../views/admin/home/home.vue'),
        children:[
            {
                path:'',
                redirect:'main'
            },
            {
                path:'main',
                name:'AdminMain',
                component:() => import('../../views/admin/home/main.vue'),
            }, 
        ],
        
    },   
    {
        path:'/admin-icon',
        component:() => import('../../views/admin/home/home-icon.vue'),
        children:[
            {
                path:'main',
                name:'AdminIconMain',
                component:() => import('../../views/admin/home/main.vue'),
            },
            {
                path:'',
                redirect:'main',
            }            
        ]
    }, 
    {
        path:'/admin-index',
        component:() => import('../../views/admin/index/index.vue'),
        children:[
                {
                    path:'course',
                    name:'CourseHome',
                    component:() => import('../../views/admin/index/course/course.vue')
                },
                {
                    path:'course-detail',
                    name:'CourseDetail',
                    component:() => import('../../views/admin/index/course/course-detail.vue')
                },
                {
                    path:'class-teaching',
                    component:() => import('../../views/admin/index/course/class-teaching.vue'),
                    children:[
                       /*  {
                            path:'course-desc',
                            name:'CourseDescription',
                            component:() => import('../../components/class-teaching/course-description.vue')
                        }, */
                        {
                            path:'class-task',
                            name:'ClassTask',
                            component:() => import('../../components/class-teaching/class-task.vue')
                        },
                        {
                            path:'class-content',
                            name:'ClassContent',
                            component:() => import('../../components/class-teaching/class-content.vue')
                        },
                        {
                            path:'class-comment',
                            name:'ClassComment',
                            component:() => import('../../components/class-teaching/class-comment.vue')
                        },
                        {
                            path:'',
                            redirect:'class-content'
                        }
                    ]
                },
                {
                    path:'bank',
                    component:() => import('../../views/admin/index/bank/bank.vue'),
                    children:[
                        {
                            path:'',
                            redirect:'questions'
                        },
                        {
                            path:'questions',
                            name:'Questions',
                            component:() => import('../../views/admin/index/bank/questions')
                        },
                        {
                            path:'favorites',
                            name:'Favorites',
                            component:() => import('../../views/admin/index/bank/favorites')
                        },
                        {
                            path:'errors',
                            name:'WrongQuestions',
                            component:() => import('../../views/admin/index/bank/errors')
                        },
                        {
                            path:'mine',
                            name:'MyPapers',
                            component:() => import('../../views/admin/index/bank/mine')
                        },
                        
                    ],
                },
                {
                    path:'preview',
                    name:'PreviewPaper',
                    component:() => import('../../views/admin/index/bank/preview.vue')
                },
                {
                    path:'final',
                    name:'FinalPaper',
                    component:() => import('../../views/admin/index/bank/final.vue')
                },
                {
                    path:'teacher',
                    name:'Teacher',
                    component:() => import('../../views/admin/index/teacher/teacher.vue'),
                },
                {
                    path:'teacher-detail',
                    component:() => import('../../views/admin/index/teacher/teacher-detail.vue'),
                    children:[
                        {
                            path:'follow',
                            name:'Follow',
                            component:() => import('../../components/teacher/teacher-detail/follow.vue')
                        },
                        {
                            path:'course',
                            name:'Course',
                            component:() => import('../../components/teacher/teacher-detail/course.vue')
                        },
                        {
                            path:'fans',
                            name:'Fans',
                            component:() => import('../../components/teacher/teacher-detail/fans.vue')
                        },
                        {
                            path:'favorite',
                            name:'Favorite',
                            component:() => import('../../components/teacher/teacher-detail/favorite.vue')
                        },
                        {
                            path:'personal',
                            name:'Personal',
                            component:() => import('../../components/teacher/teacher-detail/personal-info.vue')
                        },
                        {
                            path:'',
                            redirect:'follow'
                        }
                    ]
                },
                {
                    path:'publish',
                    name:'PublishCourse',
                    component:() => import('../../views/admin/index/teacher/publish.vue'),
                },
                {
                    path:'prepare',
                    component:() => import('../../views/admin/index/teacher/prepare.vue'),
                    children:[
                            {
                                path:'work/:type',
                                name:'StudentWork',
                                component:() => import('../../components/teacher/prepare/student-work.vue')
                            },
                            /* {
                                path:'on',
                                name:'OnClass',
                                component:() => import('../../components/teacher/prepare/on-class.vue')
                            },
                            {
                                path:'after',
                                name:'AfterClass',
                                component:() => import('../../components/teacher/prepare/after-class.vue')
                            }, */
                                
                    ]
                },
                {
                    path:'student',
                    name:'Student',
                    component:() => import('../../views/admin/index/student.vue')
                },
                {
                    path:'base',
                    name:'BasicManagement',
                    component:() => import('../../views/admin/index/base-manage/base.vue'),
                    children:[
                        {
                            path:'term',
                            name:'Term',
                            component:() => import('../../components/base-manage/dean/term-table.vue')
                        },
                        {
                            path:'time-table',
                            name:'TimeTable',
                            component:() => import('../../components/base-manage/dean/time-table.vue')
                        },
                        {
                            path:'join-year',
                            name:'JoinYear',
                            component:() => import('../../components/base-manage/dean/join-year.vue')
                        },
                        {
                            path:'team',
                            name:'TeamTable',
                            component:() => import('../../components/base-manage/dean/team.vue')
                        },
                        {
                            path:'teach-site',
                            name:'TeachSite',
                            component:() => import('../../components/base-manage/dean/teach-site.vue')
                        },
                        {
                            path:'time-table',
                            name:'TimeTable',
                            component:() => import('../../components/base-manage/dean/time-table.vue')
                        },
                        {
                            path:'campus-student',
                            name:'CampusStudentTable',
                            component:() => import('../../components/base-manage/dean/campus-student.vue')
                        },
                        {
                            path:'class',
                            name:'classTable',
                            component:() => import('../../components/base-manage/dean/class.vue')
                        },
                        {
                            path:'class-student',
                            name:'classStudentTable',
                            component:() => import('../../components/base-manage/dean/class-student.vue')
                        },
                        {
                            path:'department',
                            name:'DepartmentTable',
                            component:() => import('../../components/base-manage/dean/department.vue')
                        },
                        {
                            path:'dep-member',
                            name:'DepartmentMemberTable',
                            component:() => import('../../components/base-manage/dean/dep-member.vue')
                        },
                        {
                            path:'user-group',
                            name:'UserGroupTable',
                            component:() => import('../../components/base-manage/system/user-group.vue')
                        },
                        {
                            path:'group-permission',
                            name:'GroupPermissionTable',
                            component:() => import('../../components/base-manage/system/group-permission.vue')
                        },
                        {
                            path:'permission-definition',
                            name:'PermissionDefinitionTable',
                            component:() => import('../../components/base-manage/system/permission-definition.vue')
                        },
                        {
                            path:'system-task',
                            name:'SystemTable',
                            component:() => import('../../components/base-manage/system/system-task.vue')
                        },
                        {
                            path:'settings',
                            name:'SettingsTable',
                            component:() => import('../../components/base-manage/system/settings.vue')
                        },
                        /* {
                            path:'selector',
                            name:'SelectorTable',
                            component:() => import('../../components/base-manage/system/selector.vue')
                        }, */
                        {
                            path:'file-info',
                            name:'FileInfoTable',
                            component:() => import('../../components/base-manage/system/file-info.vue')
                        },
                        {
                            path:'vip-info',
                            name:'VipInfoTable',
                            component:() => import('../../components/base-manage/user/vip-info.vue')
                        },
                        {
                            path:'vip-file',
                            name:'VipFileTable',
                            component:() => import('../../components/base-manage/user/vip-file.vue')
                        },
                        {
                            path:'teacher-zone',
                            name:'TeacherZoneTable',
                            component:() => import('../../components/base-manage/user/teacher-zone.vue')
                        },
                        {
                            path:'student-zone',
                            name:'StudentZoneTable',
                            component:() => import('../../components/base-manage/user/student-zone.vue')
                        },
                        {
                            path:'syllabus',
                            name:'CourseSyllabus',
                            component:() => import('../../components/base-manage/course/syllabus.vue')
                        },
                        {
                            path:'content',
                            name:'CourseContent',
                            component:() => import('../../components/base-manage/course/content.vue')
                        },
                        {
                            path:'knowledge-point',
                            name:'CourseKnowLedgePoint',
                            component:() => import('../../components/base-manage/course/knowledge-point.vue')
                        },
                        {
                            path:'textbook',
                            name:'CourseTextbook',
                            component:() => import('../../components/base-manage/course/textbook.vue')
                        },
                    ]
                },
                {
                    path:'',
                    redirect:'course'
                }
        ],
    },
        
]