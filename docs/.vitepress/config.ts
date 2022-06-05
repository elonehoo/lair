import {defineConfig} from 'vitepress'

export default defineConfig({
  lang: 'en-US',
  title: 'Lair',
  description: 'Vue and SpringBoot static template',

  lastUpdated: true,

  head:[
    ['link', { rel: 'icon', href: '/logo.svg', type: 'image/svg+xml' }],
  ],

  themeConfig: {
    logo:'/logo.svg',
    nav:nav(),
    sidebar:sidebar(),
    editLink: {
      repo: 'elonehoo/static',
      branch: 'main',
      dir: 'docs',
      text: 'Edit this page on GitHub'
    },

    socialLinks: [
      { icon: 'github', link: 'https://github.com/elonehoo/static' },
      {icon: 'twitter', link: 'https://twitter.com/huchengye'},
    ],

    footer: {
      message: 'Released under the MIT License.',
      copyright: 'Copyright © 2022-present Elone Hoo'
    },
  }
})

function nav(){
  return [
    { text: 'Guide', link: '/guide/getting-started', activeMatch: '/guide/' },
    { text: 'app', link: '/app/', activeMatch: '/app/' },
    { text: 'web', link: '/web/', activeMatch: '/web/' },
  ]
}

function sidebar(){
  return {
    '/':[
      {
        text: 'Guide',
        items:[
          {text:'Why lair',link: '/guide/why'},
          {text:'Getting Started',link: '/guide/getting-started'},
          {text:'Features',link: '/guide/features'},
        ]
      },
      {
        text:'App',
        items:[
          {text:'Introduce',link:'/app/'},
        ]
      },
      {
        text:'Web',
        items:[
          {text:'Introduce',link:'/web/'},
        ]
      },
    ]
  }

}
