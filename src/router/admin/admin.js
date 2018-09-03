export default [    
    {
        path:'/admin',
        name:'Admin',
        component:() => import('../../views/admin/home/home.vue'),
        children:[
            {
                path:'main',
                name:'Main',
                component:() => import('../../views/admin/home/main.vue'),
            }, 
        ],
        
    },   
    {
        path:'/admin-icon',
        name:'AdminIcon',
        component:() => import('../../views/admin/home/home-icon.vue'),
        children:[
            {
                path:'main',
                name:'Main',
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
        name:'AdminIndex',
        component:() => import('../../views/admin/index/index.vue'),
        children:[
                {
                    path:'course',
                    name:'CourseHome',
                    component:() => import('../../components/course/course.vue')
                },
                {
                    path:'course-detail',
                    name:'CourseDetail',
                    component:() => import('../../views/admin/index/course/course-detail.vue'),
                    children:[
                        {
                            path:'course-desc',
                            name:'CourseDescription',
                            component:() => import('../../components/course-detail/course-description.vue')
                        },
                        {
                            path:'course-task',
                            name:'CourseTask',
                            component:() => import('../../components/course-detail/course-task.vue')
                        },
                        {
                            path:'course-content',
                            name:'CourseContent',
                            component:() => import('../../components/course-detail/course-Content.vue')
                        },
                        {
                            path:'course-comment',
                            name:'CourseComment',
                            component:() => import('../../components/course-detail/course-comment.vue')
                        },
                        {
                            path:'',
                            redirect:'course-content'
                        }
                    ]
                },
                {
                    path:'bank',
                    name:'Bank',
                    component:() => import('../../views/admin/index/bank/bank.vue'),
                    children:[
                        {
                            path:'compre-question',
                            name:'ComprehesiveQuestion',
                            component:() => import('../../views/admin/index/bank/question/comprehensive.vue')
                        },
                        {
                            path:'sync-question',
                            name:'SynchronousQuestion',
                            component:() => import('../../views/admin/index/bank/question/synchronous.vue')
                        },
                        {
                            path:'compose-paper',
                            name:'ComposePaper',
                            component:() => import('../../views/admin/index/bank/question/compose.vue')
                        },
                        {
                            path:'papers',
                            name:'Papers',
                            component:() => import('../../views/admin/index/bank/question/papers.vue')
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
                    name:'TeacherDetail',
                    component:() => import('../../views/admin/index/teacher/teacher-detail.vue'),
                    children:[
                        {
                            path:'follow',
                            name:'Follow',
                            component:() => import('../../components/teacher/teacher-detail/follow.vue')
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
                    name:'Prepare Lesson',
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
                    path:'',
                    redirect:'course'
                }
        ],
    },
        
]