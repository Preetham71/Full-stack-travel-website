import { Component } from '@angular/core';

@Component({
  selector: 'app-destinations',
  templateUrl: './destinations.component.html',
  styleUrl: './destinations.component.css'
})
export class DestinationsComponent {
  trending_destinations: any[] = [
    {
      name: 'France',
      title: 'THE LAND OF ROMANCE',
      image: 'https://i.pinimg.com/736x/20/e8/87/20e88750020bb3faeeecd6297dc8678e.jpg',
      tag: 'Trending'
    },
    {
      name: 'Bali',
      title: 'THE CULTURAL PARADISE',
      image: 'https://png.pngtree.com/thumb_back/fw800/background/20220108/pngtree-a-young-lady-standing-at-the-entrance-of-lempuyang-luhur-temple-bali-indonesia-photo-image_28798938.jpg',
      tag: 'Trending'
    },
    {
      name: 'Turkey',
      title: 'MAGICAL CARPET RIDES',
      image: 'https://planetofhotels.com/guide/sites/default/files/styles/paragraph__hero_banner__hb_image__popular_cities/public/live_banner/Cappadocia.jpg',
      tag: 'Popular'
    },
    {
      name: 'Vietnam',
      title: 'LAND OF ASCENDING DRAGON',
      image: 'https://www.shutterstock.com/shutterstock/photos/2183483579/display_1500/stock-photo-aerial-view-of-the-golden-bridge-is-lifted-by-two-giant-hands-in-the-tourist-resort-on-ba-na-hill-2183483579.jpg',
      tag: 'Trending'
    },
    {
      name: 'Singapore',
      title: 'THE LION CITY',
      image: 'https://www.cnstatue.com/wp-content/uploads/2019/08/Singapore-Merlion-Lion-Fish-Statue-1-600x600.jpg',
      tag: 'Popular'
    }
  ];

  visaFree_destinations: any[] = [
    {
      name: 'SriLanka',
      price: '32,500',
      image: 'https://st2.depositphotos.com/1609126/7800/i/450/depositphotos_78008644-stock-photo-temple-in-colombo-sri-lanka.jpg'
    },
    {
      name: 'Thailand',
      price: '37,500',
      image: 'https://img.freepik.com/free-photo/landmark-pagoda-doi-inthanon-national-park-chiang-mai-thailand_335224-779.jpg'
    },
    {
      name: 'Malaysia',
      price: '48,500',
      image: 'https://media.istockphoto.com/id/466842820/photo/petronas-towers.jpg?s=612x612&w=0&k=20&c=X_Kl-W_ulJEzjvaaT8gRNTQWHboyLKaedXol5EPhGdI='
    },
    {
      name: 'Seychelles',
      price: '25,500',
      image: 'https://traveler.marriott.com/wp-content/uploads/2019/10/SEZLC__Feet_In_Sand_Dining.jpg',
    },
    {
      name: 'Kenya',
      price: '90,500',
      image: 'https://www.lakenakurukenya.com/wp-content/uploads/2020/05/5-Days-Best-of-Tanzania-and-Kenya-safari.jpg',
    },
    {
      name: 'Qatar',
      price: '1,50,500',
      image: 'https://static.independent.co.uk/2023/08/03/14/iStock-905001504.jpg?width=1200&height=630&fit=crop',
    }
  ];
}
