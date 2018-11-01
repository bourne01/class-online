export default [    
    {
        path:'/teacher',
        component:() => import('../../views/teacher/home/home.vue'),
        children:[
            {
                path:'main',
                name:'TeacherMain',
                component:() => import('../../views/teacher/home/main.vue'),
            }, 
            {
                path:'',
                redirect:'main',
            }  
        ],
        
    },   
    {
        path:'/teacher-icon',
        component:() => import('../../views/teacher/home/home-icon.vue'),
        children:[
            {
                path:'main',
                name:'TeacherIconMain',
                component:() => import('../../views/teacher/home/main.vue'),
            },
            {
                path:'',
                redirect:'main',
            }            
        ]
    }, 
    {
        path:'/teacher-index',
        component:() => import('../../views/teacher/index/index.vue'),
        children:[
                {
                    path:'course',
                    name:'TeacherCourseHome',
                    component:() => import('../../views/teacher/index/course/course.vue')
                },
                {
                    path:'class-teaching',
                    component:() => import('../../views/teacher/index/course/class-teaching.vue'),
                    children:[
                        {
                            path:'class-desc',
                            name:'TeacherCourseDescription',
                            component:() => import('../../components/class-teaching/course-description.vue')
                        },
                        {
                            path:'class-task',
                            name:'TeacherCourseTask',
                            component:() => import('../../components/class-teaching/class-task.vue')
                        },
                        {
                            path:'class-content',
                            name:'TeacherCourseContent',
                            component:() => import('../../components/class-teaching/class-content.vue')
                        },
                        {
                            path:'class-comment',
                            name:'TeacherCourseComment',
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
                    component:() => import('../../views/teacher/index/bank/bank.vue'),
                    children:[
                        {
                            path:'compre-question',
                            name:'ComprehesiveQuestion',
                            component:() => import('../../views/teacher/index/bank/question/comprehensive.vue')
                        },
                        {
                            path:'sync-question',
                            name:'SynchronousQuestion',
                            component:() => import('../../views/teacher/index/bank/question/synchronous.vue')
                        },
                        {
                            path:'compose-paper',
                            name:'ComposePaper',
                            component:() => import('../../views/teacher/index/bank/question/compose.vue')
                        },
                        {
                            path:'papers',
                            name:'Papers',
                            component:() => import('../../views/teacher/index/bank/question/papers.vue')
                        },
                        
                    ],
                },
                {
                    path:'preview',
                    name:'TeacherPreviewPaper',
                    component:() => import('../../views/teacher/index/bank/preview.vue')
                },
                {
                    path:'final',
                    name:'TeacherFinalPaper',
                    component:() => import('../../views/teacher/index/bank/final.vue')
                },
                {
                    path:'teacher',
                    name:'TeacherTeacher',
                    component:() => import('../../views/teacher/index/teacher/teacher.vue'),
                },
                {
                    path:'teacher-detail',
                    component:() => import('../../views/teacher/index/teacher/teacher-detail.vue'),
                    children:[
                        {
                            path:'follow',
                            name:'TeacherFollow',
                            component:() => import('../../components/teacher/teacher-detail/follow.vue')
                        },
                        {
                            path:'fans',
                            name:'TeacherFans',
                            component:() => import('../../components/teacher/teacher-detail/fans.vue')
                        },
                        {
                            path:'favorite',
                            name:'TeacherFavorite',
                            component:() => import('../../components/teacher/teacher-detail/favorite.vue')
                        },
                        {
                            path:'personal',
                            name:'TeacherPersonal',
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
                    name:'TeacherPublishCourse',
                    component:() => import('../../views/teacher/index/teacher/publish.vue'),
                },
                {
                    path:'prepare',
                    component:() => import('../../views/teacher/index/teacher/prepare.vue'),
                    children:[
                            {
                                path:'work/:type',
                                name:'TeacherStudentWork',
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
                    path:'',
                    redirect:'course'
                }
        ],
    },
        
]